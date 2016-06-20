package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

import dao.FileCRUD;
import entity.File;

public class SmartDownloadServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	private ServletConfig config;
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");


		//新建一个SmartUpload对象
		   SmartUpload mySmartUpload= new SmartUpload("utf-8"); 
		   try{
		    //上传初始化
			    mySmartUpload.initialize(config, request, response);
		         String cid=request.getParameter("cid");
		         String ano1 = request.getParameter("ano");
		         String tid = request.getParameter("tid");
		         int ano = Integer.parseInt(ano1);
		         
		        
		         //设定contentDisposition为null以禁止浏览器
		         //自动打开文件
		         //保证单击链接后是下载文件，若不设定，则
		         //mySmartUpload.setContentDisposition(null);
		         
		         //去数据库找到这次作业的全部文件
		         FileCRUD fc = new FileCRUD();
		         List<File> list = fc.doSelectByCTA(cid, tid, ano);
		        if(list == null){
		        	//说明没有文件
		        	out.println("这次作业没有任何附件！");
		        	
		        }else{
		        	if(list.size() == 0){
		        		out.println("这次作业没有任何附件！");
		        	}else{
		        		int count = list.size();
		        		for(int i = 0; i < count; i++){
		        			String path = list.get(i).getRoot();
		        			//下载文件
		        		    mySmartUpload.downloadFile(path);
		        		}
		        	}
		        }
		    
		   }catch(Exception e){//异常处理
		    //打印自定义异常信息
		    //out.println("Download Fail.<br>");
		    //out.println(e.toString());
		    //想要打印信息可参考下面的补充说明
		   }

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		this.config=config;
	}

}
