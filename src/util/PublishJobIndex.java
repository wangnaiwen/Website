package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import dao.CourseCRUD;
import dao.FileCRUD;
import dao.PublishJobCRUD;
import dao.TeaCRUD;
import entity.Course;
import entity.Publishjob;
import entity.PublishjobId;
import entity.Teacher;
import entity.File;

public class PublishJobIndex extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	Publishjob job;
	
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

		doPost(request, response);
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
		
		
		
		// ׼���ϴ�Ŀ¼
//		String path = this.getServletContext().getRealPath("images");
		String path = "E:\\publishJob";
		java.io.File fpath = new java.io.File(path);
		if(!fpath.exists()){
			fpath.mkdir();
		}
		
		// ʵ�������
		SmartUpload su = new SmartUpload("utf-8");
		
		//IpTimeStamp its=new IpTimeStamp(InetAddress.getLocalHost().getHostAddress());//request.getRemoteAddr()����û���ip��ַ
		
		// ��ʼ�����
		su.initialize(this.getServletConfig(), request, response);
		
		try {
			
			
			// �޶��ļ����ͣ�xlsx
			//su.setAllowedFilesList("xlsx, xls");   //���Բ��޶�
			//su.setMaxFileSize(50*1024); // ���ܳ���50K
			
			// �ϴ�����ȡ�ļ�
			su.upload();
			
			String cid = su.getRequest().getParameter("cid");
			String descr = su.getRequest().getParameter("description");
			System.out.println(cid + descr);
			
			//descr = new String(descr.getBytes("ISO-8859-1"),"utf-8");
		
			String tid = Who.getTeacher();
			
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			
			if(descr.isEmpty()){
				out.println("<script>alert('��ҵ����������Ϊ�գ�'); history.back();</script>");
			}else{
				
				//�Ȳ��뵽publishJob������ٲ���file��
				int ano = getAno(cid);
				insertFileToDB(cid, ano, tid, descr, time);	
				
				int fileCount = su.getFiles().getCount();
				System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG"+fileCount);
				for(int i = 0; i < fileCount; i++){
					SmartFile file = su.getFiles().getFile(i);
					
					// �����ļ���
					/**
					 * file.getFilePathName()�ǣ���þ���·��
					 * */
					
					System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG you come here?");
					String fname = file.getFilePathName();
					
					//System.out.println(file.getFilePathName()+"		"+file.getFileExt()+"	"+file.getFieldName());
					
					//String fname = new Date().getTime()+"."+file.getFileExt();
					
					// �����ļ�
					//file.saveAs(path);
					//file.saveAs(path+"/"+fname);
					String absoluPath = path + "/" + fname;
					file.saveAs(absoluPath);
					
					//������������ݿ�
					insertFileToDB(absoluPath, tid);
				}
				
			}
			
			//SmartFile file = su.getFiles().getFile(0);
			
			
			// ��ʾ
			//
			
			// ��ȡ�ֶ���Ϣ
			//String username = su.getRequest().getParameter("username");
			
			//��ʾ����ɹ�
			//out.println("<script>alert('��ҵ�����ɹ���');location.href='publishJob.jsp';</script>");
			response.sendRedirect("http://localhost:8081/1300310118/publishJobIndex.jsp?success=yes");
			
		} catch(SecurityException e){
			out.println("<script>alert('�ļ����Ͳ���ȷ��');history.back();</script>");
			e.printStackTrace();
		}
		catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			out.println("<script>alert('�ļ��ϴ�ʧ�ܣ�');history.back();</script>");
			e.printStackTrace();
		}
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	private void insertFileToDB(String cid, int ano, String tid, String description, String time){
		
		PublishJobCRUD pjDao = new PublishJobCRUD();
		job = new Publishjob();
		
		CourseCRUD cc = new CourseCRUD();
		Course course = cc.doSelect(cid);
		
		TeaCRUD tc = new TeaCRUD();
		Teacher teacher = tc.doSelect(tid);
		
		PublishjobId jobId = new PublishjobId();
		jobId.setAno(ano+1);
		jobId.setCourse(course);
		
		job.setId(jobId);
		job.setTeacher(teacher);
		job.setTime(time);
		job.setDecription(description);
		
		pjDao.doInsert(job);
	}

	//��ѯ������ҵ�ı���������γ��Ѿ��ж��ٸ���ҵ�ˣ��Ӷ��õ���ҵ��ano
	private int getAno(String cid){
		int ano = 0;
		PublishJobCRUD pjDao = new PublishJobCRUD();
		
		List<Publishjob> list = pjDao.doSelectByCid(cid);
		if(list != null){
			ano = list.size();
		}
		return ano;
	}
	
	//���ļ���·�����浽���ݿ�
	private void insertFileToDB(String root, String tid){
		
		File file = new File(job, root);
		TeaCRUD tc = new TeaCRUD();
		Teacher teacher = tc.doSelect(tid);
		file.setTeacher(teacher);
		FileCRUD fc = new FileCRUD();
		fc.doInsert(file);
	}
	
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
