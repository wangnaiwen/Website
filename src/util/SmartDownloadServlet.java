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


		//�½�һ��SmartUpload����
		   SmartUpload mySmartUpload= new SmartUpload("utf-8"); 
		   try{
		    //�ϴ���ʼ��
			    mySmartUpload.initialize(config, request, response);
		         String cid=request.getParameter("cid");
		         String ano1 = request.getParameter("ano");
		         String tid = request.getParameter("tid");
		         int ano = Integer.parseInt(ano1);
		         
		        
		         //�趨contentDispositionΪnull�Խ�ֹ�����
		         //�Զ����ļ�
		         //��֤�������Ӻ��������ļ��������趨����
		         //mySmartUpload.setContentDisposition(null);
		         
		         //ȥ���ݿ��ҵ������ҵ��ȫ���ļ�
		         FileCRUD fc = new FileCRUD();
		         List<File> list = fc.doSelectByCTA(cid, tid, ano);
		        if(list == null){
		        	//˵��û���ļ�
		        	out.println("�����ҵû���κθ�����");
		        	
		        }else{
		        	if(list.size() == 0){
		        		out.println("�����ҵû���κθ�����");
		        	}else{
		        		int count = list.size();
		        		for(int i = 0; i < count; i++){
		        			String path = list.get(i).getRoot();
		        			//�����ļ�
		        		    mySmartUpload.downloadFile(path);
		        		}
		        	}
		        }
		    
		   }catch(Exception e){//�쳣����
		    //��ӡ�Զ����쳣��Ϣ
		    //out.println("Download Fail.<br>");
		    //out.println(e.toString());
		    //��Ҫ��ӡ��Ϣ�ɲο�����Ĳ���˵��
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
