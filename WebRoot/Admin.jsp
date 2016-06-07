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
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
<style type="text/css">
 		 #header{
			width:100%;
			height:50px;
			font-size:30px;
			font-family:宋体;
			margin-top:60px;
 		}
</style>
</head>
<body>
<div id=header align="center">
	管理员系统
</div>
<div>
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse">
							<ul class="nav">
								<li class="active">
									<a href="http://desktop-kg8cd68:8081/1300310118/first.jsp">学生注申请</a>
								</li>
								<li>
									<a href="#">老师注册申请</a>
								</li>
								<li>
									<a href="#">管理学生账号</a>
								</li>
								<li>
									<a href="#">管理教师账号</a>
								</li>
								<li>
									<a href="#">团队账号注册</a>
								</li>
								<li>
									<a href="#">个人账号注册</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div>
	<div align="center" class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						 <table border="1" spacing="2">
			
			<%
			//一页放5个
				int pageCount;
				int pageSize = 5;
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
						String passwd = list.get(i).getPassword();
						%>
						<tr>
							<td><%=sid%></td>
							<td><%=passwd %></td>
						</tr>
						<%
					}
				}
			%> 
			
		</table>
		
				<%
					if (curPage != 1){
						out.println("<a href=Admin.jsp?curPage="
								+ (curPage - 1) +">上一页</a>");
					}
					//显示超链接
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=Admin.jsp?curPage=" + j + ">["
								+ j + "]</a>");
					}
					//下一页
					if (curPage != pageCount) {
						out.println("<a href=Admin.jsp?curPage="
								+ (curPage + 1) + ">下一页</a>");
					}
				%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br><br><br><br><br>
<hr noshade="noshade" color="#FFFFFF" width="100%" size="1">
   		<div class="footer" align="center"">
     <p>Copyright &copy; 2016 Simple User Login Form. All Rights Reserved | Design by <a href="http://desktop-kg8cd68:8081/1300310118/index.jsp" id="jctd">wangnaiwen</a></p>
</div>					
</body>
</html>