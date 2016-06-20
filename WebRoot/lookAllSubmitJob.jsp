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
<%@ page import="util.Who"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lookAllSubmitJob.jsp' starting page</title>
    
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
  	所有提交作业名单
  </div>
  <body>
  <div align="center">
  		<table  border="1" width="70%">
  		<tr>
  			<td>序号</td>
  			<td>课程名称</td>
  			<td>学生学号</td>
  			<td>学生姓名</td>
  			<td>提交时间</td>
  			<td>分数</td>
  			<td>作业</td>
  		</tr>
  	<%
  		int pageCount1 = 0;
		int pageSize = 10;
		int size;
		int curPage = 1;
				
		String s_pageNow = request.getParameter("curPage");
		if (s_pageNow != null) {
			//接收到了pageNow
			curPage = Integer.parseInt(s_pageNow);
		}
						
    	String cid = request.getParameter("cid");
    	String ano1 = request.getParameter("ano");
    	int ano = Integer.parseInt(ano1);
    	
    	SubmitJobCRUD sjCRUD = new SubmitJobCRUD();
    	List<Submitjob> submitjobList = sjCRUD.doSelectByCidAno(cid, ano);
    
    	int submitCount ;
    	if(submitjobList == null){
    		submitCount = 0;
    	}else{
    	
    		submitCount = submitjobList.size();
    		if(submitCount % pageSize == 0){
				pageCount1 = submitCount/pageSize;
			}else{
				pageCount1 = submitCount/pageSize + 1;
			}
			int z = pageSize*(curPage-1);
			int k = pageSize*curPage;
			
    		for(int i = z; i< submitCount; i++){
    			if(i < k){
    		
    			Submitjob submitjob = submitjobList.get(i);
    			String score;
										
				if(submitjob.getScore() == null){
					score = "";
				}else{
					score = submitjob.getScore()+"";
				}
    			
    			String time = submitjob.getType();
    			SubmitjobId  sjId = submitjob.getId();
    			
    			String sid = sjId.getSid();
    			StuCRUD stuCRUD = new StuCRUD();
    			Student student = stuCRUD.doSelect(sid);
    			String studentName = student.getName();
    			
    			CourseCRUD courseCRUD = new CourseCRUD();
    			Course course = courseCRUD.doSelect(cid);
    			String courseName = course.getCourseName();
    			int j = i+1;
    			%>
    				<tr>
    					<td><%=j %></td>
    					<td><%=courseName %></td>
    					<td><%=sid %></td>
    					<td><%=studentName %></td>
    					<td><%=time %></td>
    					<td><%=score %></td>
    					<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/insertScoreForJob.jsp?cid=<%=cid %>&ano=<%=ano %>&sid=<%=sid %>">查看</a>
						</td>
    				</tr>
    			<%
    			}
    		}
    	}
    	
     %>
     
     </table>
     <div>
     <%
     if (curPage != 1){
			out.println("<a href=lookAllSubmitJob.jsp?curPage="
				+ (curPage - 1)+"&cid="+cid+"&ano="+ano+">上一页</a>");
		}
		//显示超链接
		for (int j = 1; j <= pageCount1 ; j++) {
			out.println("<a href=lookAllSubmitJob.jsp?curPage=" + j + "&cid="+cid+"&ano="+ano+">["
				+ j + "]</a>");
		}
		//下一页
		if (curPage != pageCount1 && submitCount != 0) {
			out.println("<a href=lookAllSubmitJob.jsp?curPage="
				+ (curPage + 1) + "&cid="+cid+"&ano="+ano+">下一页</a>");
		}
		
      %>
      <a href="http://desktop-kg8cd68:8081/1300310118/correctingJob.jsp">主页</a>	
     </div>
  </div>
  </body>
</html>
