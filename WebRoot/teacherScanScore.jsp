<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.CourseCRUD"%>
<%@ page import="entity.Course"%>
<%@ page import="entity.Teacher"%>
<%@ page import="entity.Publishjob"%>
<%@ page import="entity.PublishjobId"%>
<%@ page import="dao.PublishJobCRUD" %>
<%@ page import="util.Who"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teacherScanScore.jsp' starting page</title>
    
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
<%@include file="teacherHeader.jsp"%>

<div align="center" >
	<table border="1" width="70%">
		<tr>
			<td>课程代码</td>
			<td>课程名称</td>
			<td>作业成绩</td>
		</tr>
		<%
			String tid = Who.getTeacher();
			CourseCRUD courseCRUD = new CourseCRUD();
			List<Course> courseLists = courseCRUD.doSelectByTid(tid);
			int courseCount;
			if(courseLists == null){
				courseCount = 0;
			}else{
				courseCount = courseLists.size();
			}
			for(int i = 0; i < courseCount; i++){
				Course course = courseLists.get(i);
				String cid = course.getId();
				String courseCode = course.getCourseCode();
				String courseName = course.getCourseName();
		%>
				<tr>
					<td><%=courseCode %></td>
					<td><%=courseName %></td>
					<td>
						<a href="http://desktop-kg8cd68:8081/1300310118/allJobScoreOfCourse.jsp?cid=<%=cid %>">作业成绩</a>
					</td>
				</tr>
			
		<%
			}
		 %>
	</table>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
  </body>
</html>
