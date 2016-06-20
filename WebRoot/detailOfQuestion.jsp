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
<%@ page import="entity.QuestionId"%>
<%@ page import="entity.Teacher"%>
<%@ page import="entity.Student"%>
<%@ page import="entity.Answer"%>
<%@ page import="entity.AnswerId"%>
<%@ page import="dao.AnswerCRUD" %>
<%@ page import="util.Who"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detailOfQuestion.jsp' starting page</title>
    
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
			font-size:25px;
			font-family:宋体;
			margin-top:30px;
			margin-bottom:20px;
 		}
 		#header2{
			width:100%;
			height:30px;
			font-size:20px;
			font-family:宋体;
			margin-top:30px;
			margin-bottom:20px;
 		}
</style>
  </head>
  
  <body>
  <%
  		String cid = request.getParameter("cid");
  		String qno1 = request.getParameter("qno");
  		int qno = Integer.parseInt(qno1);
  		
  		QuestionCRUD questionCRUD = new QuestionCRUD();
  		QuestionId qId = new QuestionId();
  		
  		CourseCRUD courseCRUD = new CourseCRUD();
  		Course course = courseCRUD.doSelect(cid);
  		
  		qId.setQno(qno);
  		qId.setCourse(course);
  		
  		Question question = questionCRUD.doSelect(qId);
  		String title = question.getTitle();
  		String desc = question.getDescription();
  		
   %>
<div id=Header align="center">
	<%=title %>
</div>
<div id=Header2 align="center">
	<%=desc %>
</div>

<div align="center">
	
		<%
			AnswerCRUD answerCRUD = new AnswerCRUD();
			List<Answer> anList = answerCRUD.doSelectByCIDQNO(cid, qno);
			int anCount = 0;
			if(anList == null){
				anCount = 0;
			}else{
				anCount = anList.size();
				if(anCount != 0){
					for(int i = 0; i < anCount; i++){
						Answer answer = anList.get(i);
						String time = answer.getTime();
						String content = answer.getContent();
						String user = null;
						
						Student student = answer.getStudent();
						String img = null;
						if(student == null){
						{
							Teacher teacher = answer.getTeacher();
							user = teacher.getName();
							img = "img/teacher.jpg";
						}
						}else{
							user = student.getName();
							img = "img/student.jpg";
						}
						
						%>
						<table>
							<tr>
							<td align="center"> 
								<img alt="student" src="<%=img %>"><br>
								<%=user %><br>
							</td>
							<td>
								<textarea rows="6" cols="1" style="width:500px; min-width: 500px; height: 200px; max-height: 200px" readonly="readonly"><%=content %>
								</textarea><br>
								<p align="right">回复于:<%=time %></p>
							</td>
							</tr>
						</table>
						<hr noshade="noshade" color="#FFFFFF" width="100%" size="1">
						<%
					}
				}
			}
		 %>
	
</div>
<div align="center">
	<form action="servlet/DetailOfQuestion" method="get">
		<textarea name="content" rows="6" cols="0" style="width:700px; min-width: 700px; height: 200px; max-height: 200px"></textarea><br>
		<input type="hidden" name="cid" value="<%=cid %>">
		<input type="hidden" name="qno" value="<%=qno %>">
		<input type="submit" value="回复"> 
		<a href="http://desktop-kg8cd68:8081/1300310118/studentScanForum.jsp">主页</a>
	</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
  </body>
</html>
