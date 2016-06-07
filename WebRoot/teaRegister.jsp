<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teaRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		body{
 			background:url(img/1.jpg);
 			width:100%;
 			height:700;
 		}
 		#header{
			width:100%;
			height:100px;
			font-size:45px;
			font-family:宋体;
			margin-top:60px;
 		}
 		#content{
 			margin-top:40px;
 			font-size:30px;
 			font-family:宋体;
 			color:while;
 			padding-top:5px;
 		}
	</style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="servlet/TeaRegister" method="get">
  		<div id=header align="center">
  			教师注册系统
  		</div>
  		<div align="center">
  			工  号：<input type="text" name="tid"/><br><br>
  			密  码：<input type="password" name="password" /><br><br>
  			<input type="submit" value="提交"/>
  			<input type="reset" value="重置"/>
  		</div>
  	</form>
  </body>
</html>
