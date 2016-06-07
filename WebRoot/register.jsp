<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStuInfo.jsp' starting page</title>
    
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
	注册系统
</div>
<div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
							<form action="servlet/Register" method="get">
							<br>			
							
  							代  号：<input type="text" name="id" value="学号或工号"
  							onMouseOver="this.select();"
							onClick="if(this.value==this.defaultValue){this.value=''}" 
						 	onblur="if(this.value==''){this.value=this.defaultValue}">
						 	
						 	<br><br>
  							姓  名： <input type="text" name="name" value="你的姓名"
  							onMouseOver="this.select();"
							onClick="if(this.value==this.defaultValue){this.value=''}" 
						 	onblur="if(this.value==''){this.value=this.defaultValue}"><br><br>
						 	
  							密  码：<input type="password" name="password" value="密码"
  							onMouseOver="this.select();"
							onClick="if(this.value==this.defaultValue){this.value=''}" 
						 	onblur="if(this.value==''){this.value=this.defaultValue}" /><br><br>
						 	
  							<input type="radio" name="picRegType" value="student" checked="checked"/>学生
  							<input type="radio" name="picRegType" value="teacher"/>教师<br><br>
  							<input type="submit" value="提交"/>
  							<input type="reset" value="重置"/>
  							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
 <br><br><br><br><br><br><br><br><br><br><br>
  	<%@include file="footer.jsp" %>
  </body>
</html>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error1")%>';
  if(errori=='yes'){
      if(confirm("账号和密码都不能为空！"))
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
      if(confirm("你的注册申请已提交，等待管理员审核！是否回到登录主页？"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="index.jsp";
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