<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.CourseCRUD"%>
<%@ page import="entity.Course"%>
<%@ page import="entity.PublishjobId"%>
<%@ page import="entity.Teacher"%>
<%@ page import="dao.ScCRUD"%>
<%@ page import="dao.PublishJobCRUD"%>
<%@ page import="entity.Publishjob"%>
<%@ page import="dao.SubmitJobCRUD"%>
<%@ page import="entity.Submitjob"%>
<%@ page import="entity.SubmitjobId"%>
<%@ page import="entity.File"%>
<%@ page import="dao.FileCRUD"%>
<%@ page import="util.Who"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'JobDetailInfo.jsp' starting page</title>
    
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
	<div align="center">
	<% 
		String cid = request.getParameter("cid"); 
		String ano1 = request.getParameter("ano"); 
		int ano = Integer.parseInt(ano1); 
		String sid = Who.getStudent(); 
		 
		SubmitJobCRUD sjb = new SubmitJobCRUD(); 
		SubmitjobId sjId = new SubmitjobId(); 
		sjId.setAno(ano); 
		sjId.setCid(cid); 
		sjId.setSid(sid); 
		 
		Submitjob submitjob = sjb.doSelect(sjId); 
		String content = submitjob.getContent(); 
		String time= submitjob.getType(); 
		 
								 
		//文件部分 
		FileCRUD fc = new FileCRUD(); 
		List<File> list = fc.doSelectByCAS(cid, sid, ano); 
		 
		if(content == null){ 
			content = "本次作业没有任何描述";
		} 
	 %>
	 
							 提交时间：<%=time %><br>
							 <label style="width: 500px; height:200px">
								回答：<br>
							<%=content%>
							 </label><br>
							  附件：
							 <table border="1" width="70%">
							 <%
							 	if(list == null){
							 		//说明没有文件
		       						out.println("这次作业没有任何附件！");
							 	}else{
							 		int count = list.size();
							 		if(count == 0){
							 			out.println("这次作业没有任何附件！");
							 		}else{
							 			for(int i = 0; i < count; i++){
							 				String root = list.get(i).getRoot();
							 				
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
							  <form action="servlet/JobDetailInfo" method="get">
							  <input type="hidden" name="cid" value="<%=cid %>"><br>
							  <input type="hidden" name="ano" value="<%=ano1 %>"><br>
							  	 <input type="submit" value="删除本次作业">
							  </form>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>

  </body>
</html>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("success")%>';
  var cid ='<%=request.getParameter("cid")%>';
  var ano ='<%=request.getParameter("ano")%>';
  if(errori=='yes'){
      if(confirm("成功删除作业！"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="jobOfCourse.jsp?cid="+cid;
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>