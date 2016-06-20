<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.CourseCRUD"%>
<%@ page import="dao.ScCRUD"%>
<%@ page import="entity.Course"%>
<%@ page import="entity.Sc"%>
<%@ page import="entity.ScId"%>
<%@ page import="entity.Teacher"%>
<%@ page import="entity.Student"%>
<%@ page import="entity.Publishjob"%>
<%@ page import="entity.PublishjobId"%>
<%@ page import="dao.PublishJobCRUD" %>
<%@ page import="util.Who"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertScoreForCourse.jsp' starting page</title>
    
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
  		
		 
    <div id=Header align="center">
    	录入成绩
    </div>
	<div align="center">
	<form action="servlet/InsertScoreForCourse" method="get">
		<table  border="1" width="70%">
		<tr>
			<td>序号</td>
			<td>课程名称</td>
			<td>学生学号</td>
			<td>学生姓名</td>
			<td>分数</td>
		</tr>
		<%
			String cid = request.getParameter("cid");
			ScCRUD scCRUD = new ScCRUD();
			String courseName = null;
			List<Sc> scLists = scCRUD.doSelectByCID(cid);
			if(scLists == null){
				int counts = 0; 
			}else{
				int counts = scLists.size();
				
				for(int i = 0; i < counts; i++){
					Sc sc = scLists.get(i);
					ScId scId = sc.getId();
					Course course = scId.getCourse();
					Student student = scId.getStudent();
					courseName = course.getCourseName();
					
					String sid  = student.getSid();
					String sName = student.getName();
					String score;
					if(sc.getScore() == null){
						score = "";
					}else{
						score = sc.getScore()+"";
					}
					
					int j = i+1;
		%>
					<tr>
						<td><%=j %></td>
						<td><%=courseName %></td>
						<td><%=sid %></td>
						<td><%=sName %></td>
						<td>
							<input type="text" name="<%=i %>" value="<%=score %>">
						</td>
					</tr>
		<%
				}
			}
		 %>
		
		 </table>
		 <input type="hidden" name="cid" value="<%=cid %>">
		 <input type="submit" value="提交"> 
		 </form>
	</div>
<%@include file="footer.jsp" %>
  </body>
</html>
