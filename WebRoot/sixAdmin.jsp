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
    
    <title>My JSP 'sixAdmin.jsp' starting page</title>
    
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
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/secondAdmin.jsp">老师注册审核</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/thirdAdmin.jsp">管理学生账号</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/fourAdmin.jsp">管理教师账号</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/fiveAdmin.jsp">团队账号注册</a>
								</li>
								<li  class="active">
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
<form action="servlet/SixAdminServlet" method="get">
<div>
	<div align="center" class="row-fluid">
		<div class="span12">
			<div class="tabbable tabs-left" id="tabs-38280">
				
				<ul class="nav nav-tabs">
				
					<li class="active">
						<a href="#panel-803319" data-toggle="tab">必填信息</a>
					</li>
					<li>
						<a href="#panel-24026" data-toggle="tab">选填信息</a>
					</li>
					</ul>
					<div class="tab-content">
					
						<div class="tab-pane active" id="panel-803319">
							<div class="navbar-inner">
								<div class="container-fluid"><br>
								
								代 号：<input type="text" name="id"
								value="请输入学号或工号" 
								onMouseOver="this.select();"
								onClick="if(this.value==this.defaultValue){this.value=''}" 
						 		onblur="if(this.value==''){this.value=this.defaultValue}"><br><br>
						 
								 姓 名： <input type="text" name="name" value="输入姓名" 
								onMouseOver="this.select();"
								onClick="if(this.value==this.defaultValue){this.value=''}" 
								onblur="if(this.value==''){this.value=this.defaultValue}"><br><br>
						 
						 		密 码：<input type="password" name="password"value="password" 
								onMouseOver="this.select();"
								onClick="if(this.value==this.defaultValue){this.value=''}" 
						 		onblur="if(this.value==''){this.value=this.defaultValue}"><br><br>
						 
						 		<input type="radio" name="userType" value="teacher" checked="checked">  老师
						 		<input type="radio" name="userType" value="student">  学生<br>
					
							</div>
						</div>
		
					</div>
					<div class="tab-pane" id="panel-24026">
						<div class="navbar-inner">
								<div class="container-fluid"><br>
								
								性 别： <input type="radio" name="sex" value="man">男
									  <input type="radio" name="sex" value="woman">女 <br>
						 
								生 日：<input type="text" name="birthday"><br>
								手 机：<input type="text" name="phoneNum"><br>
								Q    Q：<input type="text" name="qq"><br>
								微 信：<input type="text" name="wechat"><br><br>
								学生选填
								<hr noshade="noshade" color="#FFFFFF" width="100%" size="1">
								
								院 系：<input type="text" name="department" ><br>
								专 业：<input type="text" name="major" ><br><br>
								教师选填
								<hr noshade="noshade" color="#FFFFFF" width="100%" size="1">
								
								职 称：<input type="text" name="grade" ><br>
								简 介：<input type="text" name="abstracts" ><br>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</div><br>
<div align="center">
	<input type="submit" value="提交">
	<input type="reset" value="重置">
</div>
</form>
   <br><br><br><br><br><br><br>
   <%@include file="footer.jsp" %>
  </body>
</html>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='yes'){
      if(confirm("代号，姓名和密码都不能为空"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       //location.href="index.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("success")%>';
  if(errori=='yes'){
      if(confirm("用户注册成功"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="sixAdmin.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
       location.href="sixAdmin.jsp";
   }
  }
</script>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error2")%>';
  if(errori=='yes'){
      if(confirm("该用户已经存在"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       //location.href="index.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>