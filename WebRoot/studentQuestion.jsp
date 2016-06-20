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
<%@ page import="dao.QuestionCRUD"%>
<%@ page import="entity.Question"%>
<%@ page import="entity.Teacher"%>
<%@ page import="entity.Student"%>
<%@ page import="entity.QuestionId"%>
<%@ page import="entity.PublishjobId"%>
<%@ page import="dao.PublishJobCRUD" %>
<%@ page import="util.Who"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentQuestion.jsp' starting page</title>
    
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
<%@include file="studentHeader.jsp"%>
<div align="center">
	<table  border="1" width="70%">
	<tr>
		<td>课程名称</td>
		<td>问题标题</td>
		<td>时间</td>
		<td>查看</td>
	</tr>
	<%
		String sid = Who.getStudent();
		
		QuestionCRUD queCRUD = new QuestionCRUD();
		List<Question> queList = queCRUD.doSelectBySID(sid);
		int queCount = 0;
		if(queList == null){
			queCount = 0;
		}else{
			queCount = queList.size();
			for(int i = 0; i < queCount; i++){
				Question question = queList.get(i);
				QuestionId quId = question.getId();
				
				Course course = quId.getCourse();
				String courseName = course.getCourseName();
				String time = question.getTime();
				String title = question.getTitle();
				String cid = course.getId();
				int qno = quId.getQno();
				%>
					<tr>
						<td><%=courseName %></td>
						<td><%=title %></td>
						<td><%=time %></td>
						<td>
							<a href="http://desktop-kg8cd68:8081/1300310118/detailOfQuestion.jsp?cid=<%=cid %>&qno=<%=qno %>">查看</a>
						</td>
					</tr>
				<%
			}
		}
	%>	
	</table>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
  </body>
</html>