<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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

<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/jquery-ui"></script>
<link href="http://www.francescomalagrino.com/BootstrapPageGenerator/3/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="http://www.francescomalagrino.com/BootstrapPageGenerator/3/js/bootstrap.min.js"></script>
<style type="text/css">
 		 #header{
			width:100%;
			height:100px;
			font-size:30px;
			font-family:����;
			margin-top:60px;
 		}
 		#content{
 			margin-top:40px;
 			font-size:20px;
 			font-family:����;
 			color:while;
 			padding-top:5px;
 		}
 		body{
 			background:url(img/2.jpg);
 			width:100%;
 			height:100%;
 		}
</style>
		
</head>
<body>
<div id=header align="center">
		<br>����Աϵͳ<br><br>
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="tabbable tabs-left" id="tabs-454189">
				<ul class="nav nav-tabs">
					<li>
						<a href="#panel-1" data-toggle="tab">ѧ��ע������</a>
					</li>
					<li >
						<a href="#panel-2" data-toggle="tab">��ʦע������</a>
					</li>
					<li class="active">
						<a href="#panel-3" data-toggle="tab">����ѧ���˺�</a>
					</li>
					<li>
						<a href="#panel-4" data-toggle="tab">�����ʦ�˺�</a>
					</li>
					<li>
						<a href="#panel-5" data-toggle="tab">�Ŷ��˺�ע��</a>
					</li>
					<li>
						<a href="#panel-6" data-toggle="tab">�����˺�ע��</a>
					</li>
				</ul>
				
				<div class="tab-content">
					<div class="tab-pane" id="panel-1">
			
					</div>
					<div class="tab-pane " id="panel-2">
									
					</div>
					
					<div class="tab-pane active" id="panel-3">
							<table border="1" spacing="2">
			
			<%
			//һҳ��5��
				int pageCount;
				int pageSize = 5;
				int size;
				int curPage = 1;
				
				String s_pageNow = request.getParameter("curPage");
				if (s_pageNow != null) {
					//���յ���pageNow
					curPage = Integer.parseInt(s_pageNow);
				}
						
				StuCRUD sc = new StuCRUD();
				List<Student> list = sc.doSelectByType(0);
				
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
						String sid = list.get(i).getSid();
						String passwd = list.get(i).getPassword();
						%>
						<tr>
							<td><%=sid%></td>
							<td><%=passwd %></td>
						</tr>
						<%
					}
				}
			%> 
			
		</table>
		
				<%
		
					if (curPage != 1){
						out.println("<a href=adminIndex.jsp?curPage="
								+ (curPage - 1) + ">��һҳ</a>");
					}
					//��ʾ������
					for (int j = 1; j <= pageCount; j++) {
						out.println("<a href=#panel-3 data-toggle=tab?curPage=" + j + ">["
								+ j + "]</a>");
					}
					//��һҳ
					if (curPage != pageCount) {
						out.println("<a href=adminIndex.jsp?curPage="
								+ (curPage + 1) + ">��һҳ</a>");
					}
				%>

					</div>
					
					<div class="tab-pane" id="panel-4">
						<p>
							���ǵ��ĸ�
						</p>
					</div>
					
					<div class="tab-pane" id="panel-5">
						<p>
							���ǵ����
						</p>
					</div>
					<div class="tab-pane" id="panel-6">
						<p>
							���ǵ�����
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br><br><br><br><br>
<%@ include file="footer.jsp" %>
</body>
</html>

