<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html"%>
<%@ page import="dao.TeaCRUD"%>
<%@ page import="entity.Teacher"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'secondAdmin.jsp' starting page</title>
    
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
	管理员系统
</div>
<div align="center">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
						<div class="nav-collapse collapse navbar-responsive-collapse" align="center">
							<ul class="nav" >
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/firstAdmin.jsp">学生注册审核</a>
								</li>
								<li  class="active">
									<a href="http://desktop-kg8cd68:8081/1300310118/secondAdmin.jsp">老师注册审核</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/thirdAdmin.jsp">管理学生账号</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/fourAdmin.jsp">管理教师账号</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/fiveAdmin.jsp">团队账号注册</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/sixAdmin.jsp">个人账号注册</a>
								</li>
								<li>
									<a href="http://desktop-kg8cd68:8081/1300310118/index.jsp">退出登录</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div>
	<div align="center" class="row-fluid">
		<div class="span12">
			<div class="navbar">
				<div class="navbar-inner">
					<div class="container-fluid">
					<form action="servlet/SecondAdminServlet" method="get">
					<br>
						 <table border="1" spacing="2" width="70%">
						 <tr>
						 	<td>工号</td>
						 	<td>姓名</td>
						 	<td>密码</td>
						 	<td>审核</td>
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
						
				TeaCRUD tc = new TeaCRUD();
				List<Teacher> list = tc.doSelectByType(0);
				
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
						String tid = list.get(i).getTid();
						String name = list.get(i).getName();
						
						String passwd = list.get(i).getPassword();
						%>
						<tr>
							<td><%=tid%></td>
							<td><%=name%></td>
							<td><%=passwd %></td>
							<td>
								<input type="radio" name=<%=i%> value="yes" checked="checked">同意
								<input type="radio" name=<%=i%> value="no">拒绝
							</td>
						</tr>
						<%
					}
				}
			%> 
			
		</table>
		
				<%
					if (curPage != 1){
						out.println("<a href=secondAdmin.jsp?curPage="
								+ (curPage - 1) +">上一页</a>");
					}
					//显示超链接
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=secondAdmin.jsp?curPage=" + j + ">["
								+ j + "]</a>");
					}
					//下一页
					if (curPage != pageCount && size != 0) {
						out.println("<a href=secondAdmin.jsp?curPage="
								+ (curPage + 1) + ">下一页</a>");
					}
				%>
				<div>
						<input type="submit" name="submit" value="提交">
						<input type="submit" name="agreeAll" value="全部同意">
						<input type="submit" name="refuseAll" value="全部拒绝">
						<input type="reset" value="重置">
					</div>
				</form>
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
