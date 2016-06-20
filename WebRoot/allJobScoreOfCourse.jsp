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
    
    <title>My JSP 'allJobScoreOfCourse.jsp' starting page</title>
    
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
  <div id=Header align="center">
  	学生作业成绩表
  </div>
  <%
  	String cid = request.getParameter("cid");
  	
  	
  	//得到这个课程布置的作业
  	PublishJobCRUD publishCRUD = new PublishJobCRUD();
  	List<Publishjob> publishList = publishCRUD.doSelectByCid(cid);
  	int pubCount;
  	if(publishList == null){
  		pubCount = 0;	
  	}else{
  		pubCount = publishList.size();
  	}
  	
  	//得到选这个课程的人数
  	ScCRUD scCRUD = new ScCRUD();
  	List<Sc> scList = scCRUD.doSelectByCID(cid);
  	int stuCount;
  	if(scList == null){
  		stuCount = 0;
  	}else{
  		stuCount = scList.size();
  	}
  	if(pubCount == 0){
  %>
  			<div align="center">
  			还没有布置任何作业
  			</div>
  <%
  	}else{
  		%>
  			<div align="center">
  				<table border="1" width="70%">
  					<tr>
  						<td>学号</td>
  						<td>姓名</td>
  						<%
  							for(int j = 0; j < pubCount; j++){
  								int k = j+1;
  								%>
  								<td>第<%=k %>次作业</td>
  								<%
  							}
  						 %>
  						<td>平均分</td>
  					</tr>
  					
  					<%
  					for(int i = 0; i < stuCount; i++){
  						Sc sc = scList.get(i);
  						ScId scId = sc.getId();
  						Student student = scId.getStudent();
  						String sid = student.getSid();
  						String sName = student.getName();
  						%>
  						<tr>
  						<td><%=sid %></td>
  						<td><%=sName %></td>
  						<%
  						int sumScore = 0;
  						for(int m=0; m<pubCount; m++){
  							Publishjob pubjob = publishList.get(m);
  							PublishjobId pubjobId = pubjob.getId();
  							int ano = pubjobId.getAno();
  							SubmitJobCRUD subCRUD = new SubmitJobCRUD();
  							List<Submitjob> submitList = subCRUD.doSelectByCSAID(cid, sid, ano);
  							if(submitList == null){
  								
  							}else{
  								if(submitList.size() == 0){
  									%>
  									<td>0</td>
  									<% 
  								}else{
  									Submitjob subjob = submitList.get(0);
  									int jobScore;
  									if(subjob.getScore() == null){
  										jobScore = 0;
  									}else{
  										jobScore = subjob.getScore();
  										sumScore += jobScore;
  									}
  									%>
  										<td><%=jobScore %></td>
  									<%
  								}
  								
  							}
  						}
  						double avgScore =(double) sumScore/pubCount;
  						DecimalFormat df = new DecimalFormat("######0.00");
  						String avg = df.format(avgScore);
  						%>
  						<td><%=avg %></td>
  						</tr>
  						<%
  					}
  					 %>
  				</table>
  			
  			</div>
  		<%
  	}
   %>
  <body>
    
<br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>
  <br></body>
</html>
