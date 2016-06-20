<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.TeaCRUD"%>
<%@ page import="entity.Teacher"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fourAdmin.jsp' starting page</title>
    
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
<%@ include file="adminHeader.jsp" %>
<div>
	<div align="center" class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
					<form action="servlet/FourAdminServlet" method="get">
					<br>
						 <table border="1" spacing="2" width="70%">
						 <tr>
						 	<td>工号</td>
						 	<td>姓名</td>
						 	<td>密码</td>
						 	<td>用户状态</td>
						 	<td>修改信息</td>
						 	<td>是否删除</td>
						 </tr>
			<%
			//一页放5个
				int pageCount;
				int pageSize = 10;
				int size;
				int curPage = 1;
				
				String s_pageNow = request.getParameter("curPage");
				if (s_pageNow != null) {
					//接收到了pageNow
					curPage = Integer.parseInt(s_pageNow);
				}
						
				TeaCRUD tc = new TeaCRUD();
				List<Teacher> list = tc.doSelectAll();
				
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
						String tid = list.get(i).getTid();
						String name = list.get(i).getName();
						String passwd = list.get(i).getPassword();
						int t= list.get(i).getType();
						String type;
						if(t == 0){
							type="等待审核";
						}else if(t == 1){
							type = "审核通过";	
						}else{
							type = "审核未通过";
						}
						%>
						<tr>
							<td><%=tid%></td>
							<td><%=name%></td>
							<td><%=passwd %></td>
							<td><%=type%></td>
							<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/modifyTeacherInfo.jsp?tid=<%=tid %>">修改信息</a>
							</td>
							<td>
								<input type="checkbox" name="delete" value=<%=tid%>>删除
							</td>
						</tr>
						<%
					}
				}
			%> 
		</table>
				<%
					if (curPage != 1){
						out.println("<a href=fourAdmin.jsp?curPage="
								+ (curPage - 1)+">上一页</a>");
					}
					//显示超链接
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=fourAdmin.jsp?curPage=" + j + ">["
								+ j + "]</a>");
					}
					//下一页
					if (curPage != pageCount && size != 0) {
						out.println("<a href=fourAdmin.jsp?curPage="
								+ (curPage + 1) + ">下一页</a>");
					}
				%>
				<div>
						<input type="submit" name="deleteSel" value="删除选中的教师">
						<input type="submit" name="deleteAll" value="删除全部教师">
						<input type="reset" value="重置">
					</div>
				</form>
					</div><br>
				</div>
			</div>
		</div>
	</div>
</div>
   <br><br><br><br><br><br><br><br><br><br><br>
<%@ include file="footer.jsp" %>
  </body>
</html>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error1")%>';
  if(errori=='yes'){
      if(confirm("至少要选中一名教师"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       //location.href="index.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>