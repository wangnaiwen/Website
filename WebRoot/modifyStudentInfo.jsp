<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.StuCRUD"%>
<%@ page import="entity.Student"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyStudentInfo.jsp' starting page</title>
    
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
	修改学生信息
</div>

<div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
						<form action="servlet/ModifyStudentInfo">
							<%
    							String id = request.getParameter("sid");
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
    									s = 1;
    								}else{
    									s = 0;
    								}
    							}
   							 %><br>
   							 <input type="hidden" name="id" value="<%=id %>">
   							 姓 名：<input type="text" name="name" value="<%=name %>"><br>
   							 密 码：<input type="text" name="password" value="<%=passwd %>"><br>
   							 生 日：<input type="text" name="birthday" value="<%=birthday %>"><br>
   							 院 系：<input type="text" name="department" value="<%=department %>"><br>
   							 专 业：<input type="text" name="major" value="<%=major %>"><br>
   							 手 机：<input type="text" name="phoneNum" value="<%=phoneNum %>"><br>
   							 Q   Q：<input type="text" name="qq" value="<%=qq %>"><br>
   							 微 信：<input type="text" name="wechat" value="<%=wechat %>"><br>
   							 
   							<%
   								if (userType == 0){
   								%>
   									审核类型：<input type="radio" name="type" value="0" checked="checked">未审核
   									 <input type="radio" name="type" value="1">已通过
   									 <input type="radio" name="type" value="3">未通过
   									 <br>
   								<%
   								}else if(userType == 1){
   								%>
   									审核类型：<input type="radio" name="type" value="0">未审核
   									 <input type="radio" name="type" value="1" checked="checked">已通过
   									 <input type="radio" name="type" value="3" >未通过
   									 <br>
   							<%
   								}else{
   								%>
   								审核类型：<input type="radio" name="type" value="0">未审核
   									 <input type="radio" name="type" value="1" >已通过
   									 <input type="radio" name="type" value="3" checked="checked">未通过
   									 <br>
   								<%
   								}
   								
   							 %>
   								<%
   								if (s==0){
   								%>
   									性 别：<input type="radio" name="sex" value="1">男
   									 <input type="radio" name="sex" value="0"  checked="checked">女<br><br>
   								<%
   								}
   								else if(s == 2){
   									%>
   										性 别：<input type="radio" name="sex" value="1">男
   										 <input type="radio" name="sex" value="0">女<br><br>
   									<%
   								}
   								else{
   								%>
   								性 别：<input type="radio" name="sex" value="1"  checked="checked">男
   									 <input type="radio" name="sex" value="0">女<br><br>
   								<%
   								}
   								
   							 %>
   							 	  
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

<br><br><br><br><br><br><br><br><br><br><br>
<hr noshade="noshade" color="#FFFFFF" width="100%" size="1">
 <div class="footer" align="center"">
     <p>Copyright &copy; 2016 Simple User Login Form. All Rights Reserved | Design by <a href="http://desktop-kg8cd68:8081/1300310118/index.jsp" id="jctd">wangnaiwen</a></p>
</div>
  </body>
</html>
<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error1")%>';
  if(errori=='yes'){
      if(confirm("姓名和密码都不能为空"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       //location.href="index.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
}
</script>
