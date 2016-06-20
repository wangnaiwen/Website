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
<%@ page import="entity.Teacher"%>
<%@ page import="entity.Student"%>
<%@ page import="entity.QuestionId"%>
<%@ page import="util.Who"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teaForumOfCourse.jsp' starting page</title>
    
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
    
 <%
  	String cid = request.getParameter("cid");
  	CourseCRUD courseCRUD = new CourseCRUD();
  	
  	Course course = courseCRUD.doSelect(cid);
  	String courseName  = course.getCourseName();
   %> 
 
 
   <body>

   <div id=Header align="center"> 
  	<br>欢迎来到<%=courseName %>课程论坛
   </div>
   <div align="center">
   		<table border="1" width="70%">
   			<tr>
   				<td>序号</td>
   				<td>姓名</td>
   				<td>问题</td>
   				<td>时间</td>
   				<td>查看</td>
   			</tr>
   			<%
   				int pageCount = 0;
				int pageSize = 10;
				int size = 0;
				int curPage = 1;
				
				String sid = Who.getStudent();
				String tid = Who.getTeacher();
						
				String s_pageNow = request.getParameter("curPage");
				if (s_pageNow != null) {
					//接收到了pageNow
					curPage = Integer.parseInt(s_pageNow);
				}
						
   				QuestionCRUD queCRUD = new QuestionCRUD();
   				List<Question> queList = queCRUD.doSelectByCid(cid);
   				int questionCount = 0;
   				if(queList == null){
   					questionCount = 0;
   					size = 0;
   				}else{
   					
   					if(queList.size() == 0){
   						
   					}else{
   						questionCount = queList.size();
   						size = questionCount;
   						if(size % pageSize == 0){
							pageCount = size/pageSize;
						}else{
							pageCount = size/pageSize + 1;
						}
						int z = pageSize*(curPage-1);
						int k = pageSize*curPage;
						
   						for(int i = z; i < size; i++){
   							if(i < k){
   								Question question = queList.get(i);
   								String userName = null;
   								String userId = null;
   								Student student = question.getStudent();
   								if(student == null){
   									Teacher teacher = question.getTeacher();
   									if(teacher == null){
   								
   									}else{
   										userId = teacher.getTid();
   										userName = teacher.getName();
   									}
   								}else{
   									userName = student.getName();
   									userId = student.getSid();
   								}
   								String time = question.getTime();
   								String title = question.getTitle();
   								QuestionId qId = question.getId();
   								int qno = qId.getQno();
   								int m = i+1;
   								%>
   							<tr>
   								<td><%=m %></td>
   								<td><%=userName %></td>
   								<td><%=title %></td>
   								<td><%=time %></td>
   								<td>
   									<a href="http://desktop-kg8cd68:8081/1300310118/teaDetailOfQuestion.jsp?cid=<%=cid %>&qno=<%=qno %>">查看回复</a>
   								</td>
   							</tr>
   							<% 
   							}
 	  					}
   					}
   				}			
   			 %>
   		</table>
   		<%
		if (curPage != 1){
			out.println("<a href=stuForumOfCourse.jsp?curPage="
				+ (curPage - 1)+"&cid="+cid+">上一页</a>");
		}
		//显示超链接
		for (int j = 1; j <= pageCount; j++) {
			out.println("<a href=stuForumOfCourse.jsp?curPage=" + j + "&cid="+cid+">["
			+ j + "]</a>");
		}
		//下一页
		if (curPage != pageCount && size != 0) {
			out.println("<a href=stuForumOfCourse.jsp?curPage="
				+ (curPage + 1) + "&cid="+cid+">下一页</a>");
		}
		
		%>
		<a href="http://desktop-kg8cd68:8081/1300310118/teacherScanForum.jsp">主页</a>
   </div>
  
    
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@include file="footer.jsp" %>    
    
    
  </body>
</html>
