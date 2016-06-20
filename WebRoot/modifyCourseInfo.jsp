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
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyCourseInfo.jsp' starting page</title>
    
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
  
 <div id=header align="center">
	修改课程信息
</div>

<div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
						<form action="servlet/ModifyCourseInfo">
							<%
    							String id = request.getParameter("id");
    							CourseCRUD cc = new CourseCRUD();
    							Course course = cc.doSelect(id);
    							
								String code = course.getCourseCode();
								String name = course.getCourseName();
								int duration = course.getCourseDuration();
								int expDuration = course.getCourseExpDuration();
								String startTime = course.getCourseStartDate();
								String endTime = course.getCourseEndDate();
								Teacher tea = course.getTeacher();
								String teacherId;
								if(tea != null){
									teacherId = tea.getTid();
								}else{
									teacherId = "";
								}
								
    							String type = course.getCourseType();
    							
    							
   							 %><br>
   							 <input type="hidden" name="id" value="<%=id %>">
   							 课程代码：<input type="text" name="code" value="<%=code %>"><br>
   							 课程名称：<input type="text" name="name" value="<%=name %>"><br>
   							 课程学时：<input type="text" name="duration" value="<%=duration %>"><br>
   							 实验学时：<input type="text" name="expDuration" value="<%=expDuration %>"><br>
   							 开始时间：<input type="text" name="startTime" value="<%=startTime %>"><br>
   							 结束时间：<input type="text" name="endTime" value="<%=endTime %>"><br>
   							 任课教师：<input type="text" name="teacherId" value="<%=teacherId %>"><br>
   							 
   								<%
   								if (type.equals("基础必修")){
   								%>
   								课程性质：<select name="type">
								<option value="基础必修" selected>基础必修</option>
								<option value="专业必修">专业必修</option>
								<option value="专业限选">专业限选</option>
								<option value="专业任选">专业任选</option>
								<option value="人文素质">人文素质</option>
								<option value="公共通识">公共通识</option>
								</select>
   								<%
   								}else if (type.equals("专业必修")){
   								%>
   								课程性质：<select name="type">
								<option value="基础必修" >基础必修</option>
								<option value="专业必修" selected>专业必修</option>
								<option value="专业限选">专业限选</option>
								<option value="专业任选">专业任选</option>
								<option value="人文素质">人文素质</option>
								<option value="公共通识">公共通识</option>
								</select>
								
   								<%
   								}else if (type.equals("专业限选")){
   								%>
   								课程性质：<select name="type">
								<option value="基础必修" >基础必修</option>
								<option value="专业必修">专业必修</option>
								<option value="专业限选" selected>专业限选</option>
								<option value="专业任选">专业任选</option>
								<option value="人文素质">人文素质</option>
								<option value="公共通识">公共通识</option>
								</select>
								<%
								}else if (type.equals("专业任选")){
   								%>
   									课程性质：<select name="type">
								<option value="基础必修" >基础必修</option>
								<option value="专业必修">专业必修</option>
								<option value="专业限选">专业限选</option>
								<option value="专业任选" selected>专业任选</option>
								<option value="人文素质">人文素质</option>
								<option value="公共通识">公共通识</option>
								</select>
   								<%
   								}else if (type.equals("人文素质")){
   									%>
   										课程性质：<select name="type">
								<option value="基础必修" >基础必修</option>
								<option value="专业必修">专业必修</option>
								<option value="专业限选">专业限选</option>
								<option value="专业任选">专业任选</option>
								<option value="人文素质" selected>人文素质</option>
								<option value="公共通识">公共通识</option>
								</select>
   								<%
   								}else if (type.equals("公共通识")){
   								%>
   								课程性质：<select name="type">
								<option value="基础必修" >基础必修</option>
								<option value="专业必修">专业必修</option>
								<option value="专业限选">专业限选</option>
								<option value="专业任选">专业任选</option>
								<option value="人文素质">人文素质</option>
								<option value="公共通识" selected>公共通识</option>
							</select>
   							 	<%
   								}else{
   								%>
   								课程性质：<select name="type">
								<option value="基础必修" >基础必修</option>
								<option value="专业必修">专业必修</option>
								<option value="专业限选">专业限选</option>
								<option value="专业任选">专业任选</option>
								<option value="人文素质">人文素质</option>
								<option value="公共通识">公共通识</option>
								</select>
   								<%
   								}
   								%>
   							 	 <br> 
   								<input type="submit" name="save" value="保存">
   								<input type="submit" name="cancel" value="取消">
   						 </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>
  </body>
</html>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("success")%>';
  if(errori=='yes'){
      if(confirm("修改成功"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="eightAdmin.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
}
</script>