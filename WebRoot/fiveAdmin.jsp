<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.TeaCRUD"%>
<%@ page import="entity.Teacher"%>
<%@ page import="dao.StuCRUD"%>
<%@ page import="entity.Student"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fiveAdmin.jsp' starting page</title>
    
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
     <div id=header align="center">
	管理员系统
</div>
<div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
							<ul class="nav" >
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/firstAdmin.jsp">学生注册审核</a>
								</li>
								<li >
									<a href="http://desktop-kg8cd68:8081/1300310118/secondAdmin.jsp">老师注册审核</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/thirdAdmin.jsp">管理学生账号</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/fourAdmin.jsp">管理教师账号</a>
								</li>
								<li class="active">
									<a href="http://desktop-kg8cd68:8081/1300310118/fiveAdmin.jsp">团队账号注册</a>
								</li>
								<li >
									<a href="http://desktop-kg8cd68:8081/1300310118/sixAdmin.jsp">个人账号注册</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/index.jsp">退出登录</a>
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
					<form action="servlet/FiveAdminServlet" method="post" enctype="multipart/form-data">
						<p>Excel表格：
    						<label for="file1"></label>
    						<input type="file" name="file1" id="file1">
  						</p>
  						<input type="radio" name="userType" value="teacher">教师
  						<input type="radio" name="userType" value="student" checked="checked">学生<br>
  						输入Excel中你的Sheet名称:<br>
  						<input type="text" name="sheet"><br>
						<input type="submit" value="提交">
					</form>
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