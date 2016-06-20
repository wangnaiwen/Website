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
    
    <title>My JSP 'jobDetail.jsp' starting page</title>
    
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
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center"><br>
							<%
								String cid = request.getParameter("cid");
								String ano1 = request.getParameter("ano");
								int ano = Integer.parseInt(ano1);
								PublishJobCRUD pjc = new PublishJobCRUD();
								
								CourseCRUD cc =new CourseCRUD();
								Course course = cc.doSelect(cid);
								
								PublishjobId pjId = new PublishjobId();
								pjId.setAno(ano);
								pjId.setCourse(course);
								
								Publishjob pj = pjc.doSelect(pjId);
								
								String time = pj.getTime();
								Teacher teacher = pj.getTeacher();
								String tid = teacher.getTid();
								String teacherName = teacher.getName();
								String desc = pj.getDecription();
								
								//文件部分
								FileCRUD fc = new FileCRUD();
								List<File> list = fc.doSelectByCTA(cid, tid, ano);
							 %>
							 <br>
							 <label style="width: 500px; height:200px">
							 时间：<%=time %> 发布人：<%=teacherName %><br>
							 描述：<br>
							<%=desc%>
							 </label><br>
							 <form enctype="multipart/form-data" method="post" action="servlet/SmartDownloadServlet"><!--
							 附件：<a href="servlet/SmartDownloadServlet?cid=<%=cid %>&ano=<%=ano %>&tid=<%=tid %>">点击下载</a>
							 附件：-->
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
							  </table>
							 </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br>

<%@include file="footer.jsp" %>
  </body>
</html>
