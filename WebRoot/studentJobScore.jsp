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
    
    <title>My JSP 'studentJobScore.jsp' starting page</title>
    
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
<br><%@include file="studentHeader.jsp"%>    
<div align = "center">
	<table border="1" width="70%">
		<tr>
			<td>课程名称</td>
			<td>作业序号</td>
			<td>作业成绩</td>
		</tr>
			<%
				String sid = Who.getStudent();
				ScCRUD scCRUD = new ScCRUD();
				List<Sc> scList = scCRUD.doSelectBySID(sid);
				
				int scCount;
				if(scList == null){
					scCount = 0;
				}else{
					if(scList.size() == 0){
					
					}else{
						scCount = scList.size();
						for(int i =0; i< scCount; i++ ){
							Sc sc = scList.get(i);
							ScId scId = sc.getId();
							Course course = scId.getCourse();
							String cName = course.getCourseName();
							String cid = course.getId();
						
							PublishJobCRUD pubCRUD = new PublishJobCRUD();
							List<Publishjob> pubjobList = pubCRUD.doSelectByCid(cid);
							int pubCount;
							if(pubjobList == null){
								pubCount = 0;
							}else{
								if(pubjobList.size() == 0){
									pubCount = 0;
								}else{
									pubCount = pubjobList.size();
									for(int j = 0; j < pubCount; j++){
										Publishjob publishjob = pubjobList.get(j);
										PublishjobId pubjobId = publishjob.getId();
										
										int ano = pubjobId.getAno();
										
										SubmitJobCRUD subCRUD = new SubmitJobCRUD();
										List<Submitjob> subList =  subCRUD.doSelectByCSAID(cid, sid, ano);
										int score = 0;
										if(subList == null){
											score = 0;
										}else{
											if(subList.size() == 0){
												score = 0;
											}else{
												if(subList.get(0).getScore() != null){
													score = subList.get(0).getScore();
												}
											}
										}
										%>
											<tr>
												<td><%=cName %></td>
												<td><%=ano %></td>
												<td><%=score %></td>
											</tr>
										<%
									}
								}
							}
						
						}
					}
					
				}
				
			%>
		
	</table>
</div>    
    
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
  </body>
</html>
