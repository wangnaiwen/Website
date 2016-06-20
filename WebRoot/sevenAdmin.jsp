<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%= basePath%>">
    
    <title>My JSP 'adminSeven.jsp' starting page</title>
    
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
    <%@ include file="adminHeader.jsp" %>
    
    <div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
						<form action="servlet/SevenAdminServlet" method="get"><br>
							课号(ID)： <input type="text" name="cid"><br>
							
							课程代码： <input type="text" name="ccode"><br>
							课程名称： <input type="text" name="cname"><br>
							理论学时： <input type="text" name="cduration"><br>
							实验学时： <input type="text" name="cexpduration"><br>
							开始时间： <input type="text" name="cstarttime"><br>
							结束时间： <input type="text" name="cendtime"><br>
							任课教师： <input type="text" name="cteacher"><br>
							课程性质：<select name="ctype">
								<option value="基础必修" selected>基础必修</option>
								<option value="专业必修">专业必修</option>
								<option value="专业限选">专业限选</option>
								<option value="专业任选">专业任选</option>
								<option value="人文素质">人文素质</option>
								<option value="公共通识">公共通识</option>
							</select><br>
   							<br><input type="submit" name="save" value="添加">
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
      if(confirm("开课成功"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="sevenAdmin.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
}
</script>
