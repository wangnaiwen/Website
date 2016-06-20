<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.CourseCRUD"%>
<%@ page import="entity.Course"%>
<%@ page import="entity.Teacher"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%= basePath%>">
    
    <title>My JSP 'adminEight.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%@ include file="adminHeader.jsp" %>


<div>
	<div align="center" class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
					<form action="servlet/EightAdminServlet" method="get">
					<br>
						 <table border="1" spacing="2" width="70%">
						 <tr>
						 	<td>课号</td>
						 	<td>课程代码</td>
						 	<td>课程性质</td>
						 	<td>课程名称</td>
						 	<td>课程学时</td>
						 	<td>实验学时</td>
						 	<td>开始时间</td>
						 	<td>结束时间</td>
						 	<td>任课教师</td>
						 	<td>修改信息</td>
						 	<td>是否删除</td>
						 </tr>
			<%
			//一页放5个
				int pageCount;
				int pageSize = 10;
				int size;
				int curPage = 1;
				
				String s_pageNow = request.getParameter("curPage");
				if (s_pageNow != null) {
					//接收到了pageNow
					curPage = Integer.parseInt(s_pageNow);
				}
						
				CourseCRUD sc = new CourseCRUD();
				List<Course> list = sc.doSelectAll();
				
				size = list.size();
				
				if(size % pageSize == 0){
					pageCount = size/pageSize;
				}else{
					pageCount = size/pageSize + 1;
				}
				int z = pageSize*(curPage-1);
				int k = pageSize*curPage;
				for(int i = z; i < size;i++){
					if(i < k){
						String id = list.get(i).getId();
						String code = list.get(i).getCourseCode();
						String type = list.get(i).getCourseType();
						String name = list.get(i).getCourseName();
						int duration = list.get(i).getCourseDuration();
						int expDuration = list.get(i).getCourseExpDuration();
						String startTime = list.get(i).getCourseStartDate();
						String endTime = list.get(i).getCourseEndDate();
						Teacher tea = list.get(i).getTeacher();
						String teacherName;
						if(tea != null){
							teacherName = tea.getName();
						}else{
							teacherName = "";
						}
						
						%>
						<tr>
							<td><%=id%></td>
							<td><%=code%></td>
							<td><%=type%></td>
							<td><%=name%></td>
							<td><%=duration%></td>
							<td><%=expDuration%></td>
							<td><%=startTime%></td>
							<td><%=endTime%></td>
							<td><%=teacherName%></td>
							<td>
								<a href="http://desktop-kg8cd68:8081/1300310118/modifyCourseInfo.jsp?id=<%=id %>">修改信息</a>
							</td>
							<td>
								<input type="checkbox" name="delete" value=<%=id%>>删除
							</td>
						</tr>
						<%
					}
				}
			%> 
		</table>
				<%
					if (curPage != 1){
						out.println("<a href=eightAdmin.jsp?curPage="
								+ (curPage - 1)+">上一页</a>");
					}
					//显示超链接
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=eightAdmin.jsp?curPage=" + j + ">["
								+ j + "]</a>");
					}
					//下一页
					if (curPage != pageCount && size != 0) {
						out.println("<a href=eightAdmin.jsp?curPage="
								+ (curPage + 1) + ">下一页</a>");
					}
				%>
				<div>
						<input type="submit" name="deleteSel" value="删除选中的课程">
						<input type="submit" name="deleteAll" value="删除全部课程">
						<input type="reset" value="重置">
					</div>
				</form>
					</div><br>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>
  </body>
</html>
