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
<%@ page import="util.Who"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jobOfCourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
<div align="center" id=header>
	我的作业
</div>
<div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
						<br>
							 <table border="1" width="70%">
							 <tr>
							 	<td>课程名称</td>
						 		<td>作业序号</td>
						 		<td>发布时间</td>
						 		<td>发布教师</td>
						 		<td>提交状态</td>
						 		<td>查看</td>
							 </tr>
							<%
						int pageCount;
						int pageSize = 10;
						int size;
						int curPage = 1;
				
						String cid = request.getParameter("cid");
						String sid = Who.getStudent();
						String s_pageNow = request.getParameter("curPage");
						if (s_pageNow != null) {
							//接收到了pageNow
							curPage = Integer.parseInt(s_pageNow);
						}
						
						
						PublishJobCRUD pjc = new PublishJobCRUD();
						
						List<Publishjob> list = pjc.doSelectByCid(cid);
				
						if(list == null){
							size = 0;
						}else{
							size = list.size();
						}
				
						if(size % pageSize == 0){
							pageCount = size/pageSize;
						}else{
							pageCount = size/pageSize + 1;
						}
						int z = pageSize*(curPage-1);
						int k = pageSize*curPage;
						for(int i = z; i < size;i++){
						if(i < k){
							
							Publishjob job = list.get(i);
							Teacher teacher = job.getTeacher();
							String time = job.getTime();
							String teacherName = teacher.getName();
							PublishjobId jobId = job.getId();
							
							Course course = jobId.getCourse();
							int ano = jobId.getAno();
							String cname = course.getCourseName();
							
							SubmitJobCRUD sjc = new SubmitJobCRUD();
							List<Submitjob> list2 = sjc.doSelectByCSAID(cid, sid, ano);
							
							String type;
							
							if(list2 == null){
								//找不到，说明没有提交作业
								type = "未提交";
							}else{
								if(list2.size() == 0){
									type = "未提交";
								}else{
									type = "已提交";
								}
							}
							//Submitjob sj = list2.get(0);
							//SubmitjobId sjid = sj.getId();

						
						%>
						<tr>
							<td><%=cname %></td>
							<td>第<%=ano %>次</td>
							<td><%=time %></td>
							<td><%=teacherName %></td>
							<%
								if(type.equals("已提交")){
							 %>
							<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/jobDetailInfo.jsp?cid=<%=cid %>&ano=<%=ano %>">已提交</a>
							</td>
							<%}
							else{
							%>
							<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/submit.jsp?cid=<%=cid %>&ano=<%=ano %>">进入提交</a>
							</td>
							<%
							}
							%>
							<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/jobDetail.jsp?cid=<%=cid %>&ano=<%=ano %>">详情</a>
							</td>
						</tr>
						<%
					}
				}
			%> 
		</table>
				<%
					if (curPage != 1){
						out.println("<a href=jobOfCourse.jsp?curPage="
								+ (curPage - 1)+">上一页</a>");
					}
					//显示超链接
					
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=jobOfCourse.jsp?curPage=" + j + ">["
								+ j + "]</a>");
					}
					
					//下一页
					if (curPage != pageCount && size != 0) {
						out.println("<a href=jobOfCourse.jsp?curPage="
								+ (curPage + 1) + ">下一页</a>");
					}
				%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <%@ include file="footer.jsp" %>
  </body>
</html>
