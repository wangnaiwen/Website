<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function
  	</script>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   		<br>网络教学辅助系统 <br><br>
   </div>
   <div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
							<form action="servlet/Login" method="get">
   								<div id=content align="center">
   								<br>
   		      					   账 户: <input type="text" name="userid" style="width:200px;height:22px"/><br><br>
   								  密 码: <input type="password" name="password" style="width:200px;height:22px"/><br><br>
   									<input type="radio" name="loginType" value="student" checked="checked"/>学生
   									<input type="radio" name="loginType" value="teacher"/>教师
   									<input type="radio" name="loginType" value="admin"/>管理员<br><br>
   									<input type="submit" name="login" value="登录" />
   									<input type="reset" name="login" value="重置" />  
   									<a href="http://desktop-kg8cd68:8081/1300310118/register.jsp">注册</a>
   			
   								</div>
  							 </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br><br><br><br><br><br><br><br>
   <%@include file="footer.jsp" %>
  </body>
</html>

<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error1")%>';
  if(errori=='yes'){
      if(confirm("无此账号！"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       //location.href="menu.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error2")%>';
  if(errori=='yes'){
      if(confirm("密码错误，请重新输入你的密码！"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       //location.href="menu.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error3")%>';
  if(errori=='yes'){
      if(confirm("注册信息已提交，等待管理员的审核"))
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
      if(confirm("登录成功！"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="firstAdmin.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("success2")%>';
  
  if(errori=='yes'){
      if(confirm("登录成功！"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="studentCourse.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("success3")%>';
  if(errori=='yes'){
      if(confirm("登录成功！"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="teacherCourse.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>
