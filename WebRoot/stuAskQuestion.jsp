<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.CourseCRUD"%>
<%@ page import="entity.Course"%>
<%@ page import="dao.ScCRUD"%>
<%@ page import="entity.Sc"%>
<%@ page import="entity.ScId"%>
<%@ page import="dao.SubmitJobCRUD"%>
<%@ page import="entity.Submitjob"%>
<%@ page import="entity.Teacher"%>
<%@ page import="entity.Student"%>
<%@ page import="entity.Publishjob"%>
<%@ page import="entity.PublishjobId"%>
<%@ page import="dao.PublishJobCRUD" %>
<%@ page import="util.Who"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stuAskQuestion.jsp' starting page</title>
    
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
  <%
  String cid = request.getParameter("cid");
   %>
  <body>
<div id=Header align="center"> 
	<br>我要提问 
</div>
<div align="center">
	<form action="servlet/StuAskQuestion" method="get">
	*你的问题是：
	<input type="hidden" name="cid" value="<%=cid%>"><br>
	<textarea rows="6" cols="2" style="width: 500px; max-width: 500px; height: 100px; max-height: 100px" name="title" ></textarea>
	<br>*问题的描述:<br>
	<textarea rows="6" cols="2" style="width: 500px; max-width: 500px; height: 200px; max-height: 300px" name="content" ></textarea>
	<br><input type="submit" value="提交"> <input type="reset" value="重置">
	</form>
</div>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
  </body>
</html>
