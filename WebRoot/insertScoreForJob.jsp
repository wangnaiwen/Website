<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.StuCRUD"%>
<%@ page import="dao.CourseCRUD"%>
<%@ page import="entity.Course"%>
<%@ page import="entity.Student"%>
<%@ page import="entity.Publishjob"%>
<%@ page import="entity.PublishjobId"%>
<%@ page import="dao.PublishJobCRUD" %>
<%@ page import="entity.Submitjob"%>
<%@ page import="entity.SubmitjobId"%>
<%@ page import="dao.SubmitJobCRUD" %>
<%@ page import="entity.File"%>
<%@ page import="dao.FileCRUD"%>
<%@ page import="util.Who"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertScoreForJob.jsp' starting page</title>
    
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
  	<%
  		String cid = request.getParameter("cid");
  		String sid = request.getParameter("sid");
  		String ano1 = request.getParameter("ano");
  		int ano = Integer.parseInt(ano1);
  		
  		StuCRUD stuCRUD = new StuCRUD();
  		Student student = stuCRUD.doSelect(sid);
  		String studentName =  student.getName();
  		
  		SubmitJobCRUD submitjobCRUD = new SubmitJobCRUD();
  		SubmitjobId sjId = new SubmitjobId();
  		
  		sjId.setAno(ano);
  		sjId.setCid(cid);
  		sjId.setSid(sid);
  		
  		
  		Submitjob submitjob = submitjobCRUD.doSelect(sjId);
  		//List<Submitjob> list = submitjobCRUD.doSelectByCSAID(cid, sid, ano);
  		
  		if(submitjob == null){
  			System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");
  		}
  		String content = submitjob.getContent();
  		String time = submitjob.getType();
  		
  		FileCRUD fileCRUD = new FileCRUD();
  		List<File> files = fileCRUD.doSelectByCAS(cid, sid, ano);
  	 %>
    <div id=Header align="center">
    	<%=studentName %>的作业
    </div>
    <div align="center">
    	时间：<%=time %> 提交人:<%=studentName %><br>
    	作业的描述如下：<br>
    	<label style="width: 500px; height:200px">
    		<%=content %>
    	</label>
    	
    	<table border="1" width="70%">
			 <%
				if(files == null){
					//说明没有文件
		       		out.println("这次作业没有任何附件！");
				}else{
				int count = files.size();
				if(count == 0){
					out.println("这次作业没有任何附件！");
				}else{
					for(int i = 0; i < count; i++){
						String root = files.get(i).getRoot();
						int num = i+1;
			%>
				<tr>
					<td>
						附件<%=num %>
					</td>
					<td>
						<a href="do_download.jsp?root=<%=root %>">点击下载</a>
					</td>
				</tr>
			<%
					}
				}
			}
			%>
	 </table><br>
	 <form action="servlet/InsertScoreForJob" method="get" >
	 		<input type="hidden" name="cid" value="<%=cid %>">
	 		<input type="hidden" name="ano" value="<%=ano %>">
	 		<input type="hidden" name="sid" value="<%=sid %>">
	 	分数：<input type="text" name="score">
	 	<input type="submit" value="提交">
	 </form>
    </div>
  </body>
</html>
