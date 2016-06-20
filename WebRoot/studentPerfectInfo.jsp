<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.StuCRUD"%>
<%@ page import="entity.Student"%>
<%@ page import="util.Who"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentPerfectInfo.jsp' starting page</title>
    
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
<%@include file="studentHeader.jsp"%>
   <div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
						<form action="servlet/StudentPerfectInfo" method="get"><br>
							
							<%
    							String id = Who.getStudent();
    							Student student = new Student();
    							StuCRUD sc = new StuCRUD();
    							student = sc.doSelect(id);
    							
    							String name = student.getName(); 	
    							String passwd = student.getPassword();						
    							String birthday = student.getBirthday();
    							String department = student.getDepartment();
    							String major = student.getMajor();
    							String phoneNum = student.getPhoneNumber();
    							String qq = student.getQq();
    							String wechat = student.getWechat();
    							
    							if(birthday == null){
    								birthday = "";
    							}
    							if(name == null){
    								name = "";
    							}
    							if(department == null){
    								department = "";
    							}
    							if(major == null){
    								major = "";
    							}
    							if(phoneNum == null){
    								phoneNum = "";
    							}
    							if(qq == null){
    								qq = "";
    							}
    							if(wechat == null){
    								wechat = "";
    							}
    							
    							String sex = student.getSex();
    							int userType = student.getType();
    							int s;
    							if(sex == null){
    								s = 2;
    							}else{
    								if(sex.equals("woman")){
    									s = 0;
    								}else{
    									s = 1;
    								}
    							}
   							 %><br>
   							<%
   								if (s==0){
   								%>
   									性 别：<input type="radio" name="sex" value="man">男
   									 <input type="radio" name="sex" value="woman"  checked="checked">女<br><br>
   								<%
   								}
   								else if(s == 2){
   									%>
   										性 别：<input type="radio" name="sex" value="man" checked="checked">男
   										 <input type="radio" name="sex" value="woman">女<br><br>
   									<%
   								}
   								else{
   								%>
   								性 别：<input type="radio" name="sex" value="man"  checked="checked">男
   									 <input type="radio" name="sex" value="woman">女<br><br>
   								<%
   								}
   							 %>		
   							 <input type="hidden" name="passwd" value="<%=passwd %>">
   							 姓 名：<input type="text" name="name" value="<%=name %>"><br>
   							 生 日：<input type="text" name="birthday" value="<%=birthday %>"><br>
   							 院 系：<input type="text" name="department" value="<%=department %>"><br>
   							 专 业：<input type="text" name="major" value="<%=major %>"><br>
   							 手 机：<input type="text" name="phoneNum" value="<%=phoneNum %>"><br>
   							 Q   Q：<input type="text" name="qq" value="<%=qq %>"><br>
   							 微 信：<input type="text" name="wechat" value="<%=wechat %>"><br>
								<input type="submit" value="提交">
								<input type="reset" value="重置">
   						 </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

   <br><br><br><br><br><br><br>

<%@include file="footer.jsp" %>
  </body>
</html>
