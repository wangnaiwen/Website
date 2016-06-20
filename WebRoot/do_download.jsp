<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.jspsmart.upload.*" %>
<%@ page import="dao.FileCRUD" %>
<%@ page import="entity.File" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'do_download.jsp' starting page</title>
    
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
    <%   
  //新建一个SmartUpload对象  
  SmartUpload su=new SmartUpload("utf-8");  
  //初始化  
  su.initialize(pageContext);  
  //设定contentDisposition为null以禁止浏览器自动打开文件,  
  //保证点击连接后是下载文件。若不设定，则下载的文件扩展名为doc时，  
  //浏览器将自动用word打开。扩展名为pdf时，浏览器将用acrobat打开.  
  
  su.setContentDisposition(null);  
  //下载文件  
  try{
		String root = request.getParameter("root");
		root = new String(root.getBytes("ISO-8859-1"),"utf-8");
		        
		//设定contentDisposition为null以禁止浏览器
		 //自动打开文件
		  //保证单击链接后是下载文件，若不设定，则
		  //mySmartUpload.setContentDisposition(null);
		 //去数据库找到这次作业的全部文件
		
		
		//下载文件
	   su.downloadFile(root);
	   response.getOutputStream().close();

 	 
  }catch(Exception e){
  		System.out.println("yes");
  }
  
%> 
  </body>
</html>
