
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.CourseCRUD"%>
<%@ page import="entity.Course"%>
<%@ page import="entity.Teacher"%>
<%@ page import="util.Who"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teacherCourse.jsp' starting page</title>
    
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
						 		<td>课号</td>
						 		<td>课程名称</td>
						 		<td>课程代码</td>
						 		<td>课程性质</td>
						 		<td>课程学时</td>
						 		<td>实验学时</td>
						 		<td>开始时间</td>
						 		<td>结束时间</td>
						 		<td>添加学生</td>
						 		<td>批量导入学生</td>
						 		<td>学生名单</td>
							 </tr>
							<%
			
						int pageCount;
							int pageSize = 10;
						int size;
						int curPage = 1;
				
						String s_pageNow = request.getParameter("curPage");
						if (s_pageNow != null) {
							//接收到了pageNow
							curPage = Integer.parseInt(s_pageNow);
						}
						
						CourseCRUD cc = new CourseCRUD();
						String id = Who.getTeacher();
						List<Course> list = cc.doSelectByTid(id);
				
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
							String cid = list.get(i).getId(); 
							String name = list.get(i).getCourseName() ;
							String code = list.get(i).getCourseCode();
							String type = list.get(i).getCourseType();
							int duration = list.get(i).getCourseDuration();
							int expDuration = list.get(i).getCourseExpDuration();
							String startTime = list.get(i).getCourseStartDate();
							String endTime = list.get(i).getCourseEndDate();
						%>
						<tr>
							<td><%=cid%></td>
							<td><%=name%></td>
							<td><%=code %></td>
							<td><%=type %></td>
							<td><%=duration %></td>
							<td><%=expDuration %></td>
							<td><%=startTime %></td>
							<td><%=endTime %></td>
							<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/addStudentToCourse.jsp?cid=<%=cid %>">添加学生</a>
							</td>
							<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/batchInsertStuToCou.jsp?cid=<%=cid %>">批量导入</a>
							</td>
							<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/allStudentOfCourse.jsp?cid=<%=cid %>">学生名单</a>
							</td>
						</tr>
						<%
					}
				}
			%> 
		</table>
				<%
					if (curPage != 1){
						out.println("<a href=teacherCourse.jsp?curPage="
								+ (curPage - 1)+">上一页</a>");
					}
					//显示超链接
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=teacherCourse.jsp?curPage=" + j + ">["
								+ j + "]</a>");
					}
					//下一页
					if (curPage != pageCount && size != 0) {
						out.println("<a href=teacherCourse.jsp?curPage="
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

<%@include file="footer.jsp" %>
  </body>
</html>
