<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.StuCRUD"%>
<%@ page import="entity.Student"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'first.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
<!--	
<style type="text/css">
 		 #header{
			width:100%;
			height:100px;
			font-size:30px;
			font-family:宋体;
			margin-top:60px;
 		}
 		#content{
 			margin-top:40px;
 			font-size:20px;
 			font-family:宋体;
 			color:while;
 			padding-top:5px;
 		}
 		body{
 			background:url(img/2.jpg);
 			width:100%;
 			height:100%;
 		}
</style>
  </head>
  
 
  <head> -->
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
					<form action="servlet/FirstAdminServlet" method="get">
					<br>
						 <table border="1" spacing="2" width="70%">
						 <tr>
						 	<td>学号</td>
						 	<td>姓名</td>
						 	<td>密码</td>
						 	<td>审核</td>
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
						
				StuCRUD sc = new StuCRUD();
				List<Student> list = sc.doSelectByType(0);
				
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
						String sid = list.get(i).getSid();
						String name = list.get(i).getName();
						
						String passwd = list.get(i).getPassword();
						%>
						<tr>
							<td><%=sid%></td>
							<td><%=name%></td>
							<td><%=passwd %></td>
							<td>
								<input type="radio" name=<%=i%> value="yes" checked="checked">同意
								<input type="radio" name=<%=i%> value="no">拒绝
							</td>
						</tr>
						<%
					}
				}
			%> 
		</table>
				<%
					if (curPage != 1){
						out.println("<a href=firstAdmin.jsp?curPage="
								+ (curPage - 1)+">上一页</a>");
					}
					//显示超链接
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=firstAdmin.jsp?curPage=" + j + ">["
								+ j + "]</a>");
					}
					//下一页
					if (curPage != pageCount && size != 0) {
						out.println("<a href=firstAdmin.jsp?curPage="
								+ (curPage + 1) + ">下一页</a>");
					}
				%>
				<div>
						<input type="submit" name="submit" value="提交">
						<input type="submit" name="agreeAll" value="全部同意">
						<input type="submit" name="refuseAll" value="全部拒绝">
						<input type="reset" value="重置">
					</div>
				</form>
					</div><br>
				</div>
			</div>
		</div>
	</div>
</div>
   <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@ include file="footer.jsp" %>
  </body>
</html>
