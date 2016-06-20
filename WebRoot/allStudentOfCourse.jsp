<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.ScCRUD"%>
<%@ page import="entity.Sc"%>
<%@ page import="entity.ScId"%>
<%@ page import="entity.Student"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allStudenteOfCourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
	<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
	<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
	<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
	<style type="text/css">
 	#header{
		width:100%;
		height:30px;
		font-size:30px;
		font-family:宋体;
		margin-top:30px;
		margin-bottom:20px;
 	}
 	</style>
  </head>
  
  <body>
    <div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center"><br>
							<form action="servlet/AllStudentOfCourse" method="get">
							<br>
						 <table border="1" width="70%">
						 <tr>
						 	<td>课号</td>
						 	<td>学号</td>
						 	<td>学生姓名</td>
						 	<td>分数</td>
						 	<td>是否删除</td>
						 </tr>
			<%
			//一页放5个
				int pageCount;
				int pageSize = 10;
				int size;
				int curPage = 1;
				String cid = request.getParameter("cid");
				
				String s_pageNow = request.getParameter("curPage");
				if (s_pageNow != null) {
					//接收到了pageNow
					curPage = Integer.parseInt(s_pageNow);
				}
						
				ScCRUD scc = new ScCRUD();
				List<Sc> list = scc.doSelectByCID(cid);
				
				size = list.size();
				
				if(size % pageSize == 0){
					pageCount = size/pageSize;
				}else{
					pageCount = size/pageSize + 1;
				}
				int z = pageSize*(curPage-1);
				int k = pageSize*curPage;
				for(int i = z; i < size;i++){
					if(i < k){
						ScId scid = list.get(i).getId();		
						
						String score;
										
						if(list.get(i).getScore() == null){
							score = "";
						}else{
							score = list.get(i).getScore()+"";
						}
						Student stu = scid.getStudent();				
						String sid = stu.getSid();
						String sname = stu.getName();
			
						%>
						<tr>
							<td><%=cid%></td>
							<td><%=sid%></td>
							<td><%=sname%></td>
							<td><%=score%></td>
							<td>
								<input type="checkbox" name="delete" value="<%=sid %>"> 删除
							</td>
						</tr>
						<%
					}
				}
			%> 
		</table>
				<%
					if (curPage != 1){
						out.println("<a href=allStudentOfCourse.jsp?curPage="
								+ (curPage - 1)+">上一页</a>");
					}
					//显示超链接
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=allStudentOfCourse.jsp?curPage=" + j + ">["
								+ j + "]</a>");
					}
					//下一页
					if (curPage != pageCount && size != 0) {
						out.println("<a href=allStudentOfCourse.jsp?curPage="
								+ (curPage + 1) + ">下一页</a>");
					}
				%>
				<div>
						<input type="hidden" name="cid" value="<%=cid %>">
						<input type="submit" value="删除">
						<input type="reset" value="重置">
					</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br>
    <%@ include file="footer.jsp" %>
  </body>
</html>
