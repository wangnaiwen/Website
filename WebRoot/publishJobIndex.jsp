<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'publishJobIndex.jsp' starting page</title>
    
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
						<form action="servlet/PublishJobIndex" method="post" enctype="multipart/form-data">
						
							<%
								String cid = request.getParameter("cid");
							 %>
							<input type="hidden" name="cid" value="<%=cid %>">
							*作业的描述: <br><br>
							<textarea cols="200" name="description" style="height: 300px; width: 800px;max-width:800px;max-height:300px"; >
							</textarea><br><br>
							<input type="file"  name="file" multiple="multiple"> <br>
							<input type="submit" value="提交">		
							<input type="reset" value="重置"><br>
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

<script> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("success")%>';
  if(errori=='yes'){
      if(confirm("成功发布作业！"))
   {//如果是true ，那么就把页面转向thcjp.cnblogs.com
       location.href="publishJob.jsp";
   }
   else  
   {//否则说明下了，赫赫
       //alert("你按了取消，那就是返回false");
   }
  }
</script>