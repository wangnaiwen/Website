package util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import controler.ScExcelCon;
import controler.StuExcelCon;
import dao.CourseCRUD;
import dao.ScCRUD;
import dao.StuCRUD;
import entity.Course;
import entity.Sc;
import entity.ScId;
import entity.Student;

public class BatchInsertStuToCou extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	private int success = 0;
	private int failth = 0;
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		
		success = 0;
		failth = 0;
		// ׼���ϴ�Ŀ¼
//		String path = this.getServletContext().getRealPath("images");
		String path = "E:\\upload";
		
		File fpath = new File(path);
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
			su.setAllowedFilesList("xlsx, xls");   //���Բ��޶�
			//su.setMaxFileSize(50*1024); // ���ܳ���50K
			
			// �ϴ�����ȡ�ļ�
			su.upload();
			SmartFile file = su.getFiles().getFile(0);
			
			// �����ļ���
			/**
			 * file.getFilePathName()�ǣ���þ���·��
			 * */
			
			String fname = file.getFilePathName();
			
			//System.out.println(file.getFilePathName()+"		"+file.getFileExt()+"	"+file.getFieldName());
			
			//String fname = new Date().getTime()+"."+file.getFileExt();
			
			// �����ļ�
			//file.saveAs(path);
			//file.saveAs(path+"/"+fname);
			String absoluPath = path + "/" + fname;
			file.saveAs(absoluPath);
			
			// ��ʾ
			//out.println("<script>alert('�ļ��ϴ��ɹ���');location.href='upload.jsp';</script>");
			
			// ��ȡ�ֶ���Ϣ
			//String username = su.getRequest().getParameter("username");
			
			String cid = su.getRequest().getParameter("cid");
			String sheet = su.getRequest().getParameter("sheet");
			
			
			// �������ݿ����
			//1.�ļ���  2.�ļ�·��   
			//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+sheet+"	"+ "	"+userType+"	"+fname);
			
			//��ȡ�ļ�������
			String fileType = file.getFileExt(); 
			
			
			boolean juede = insertAllStudent(absoluPath, sheet, fileType, cid);
			if(juede){
				//out.println("<script>alert('�ɹ�'"+success+"'����¼��ʧ��'" + failth +"'��¼');location.href='fiveAdmin.jsp';</script>");
				String hint = "�ɹ�"+success+"����ʧ��"+failth+"����";
				out.println("<script>alert('"+ hint +"');history.back();</script>");
			}else{
				out.println("<script>alert('�Ҳ����κμ�¼'); history.back();</script>");
			}
			
		} catch(SecurityException e){
			out.println("<script>alert('ֻ�ܴ�xlsx, xls���ļ��������������ݣ�');history.back();</script>");
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

	private boolean insertAllStudent(String path, String sheet, String fileType, String cid){
		ScCRUD scc = new ScCRUD();
		ScExcelCon se = new ScExcelCon();
		if(fileType.equals("xlsx")){
			try{
				List<String> list = se.readXlsx(path, sheet);
				if(list == null){
					return false;
				}
				for(int i = 0; i < list.size(); i++){
					String sid = list.get(i);
					Sc sc = new Sc();
					ScId scId = new ScId();
						
					CourseCRUD courseCRUD = new CourseCRUD();
					Course course = courseCRUD.doSelect(cid);
						
					StuCRUD stuCRUD = new StuCRUD();
					Student student = stuCRUD.doSelect(sid);
						
					scId.setCourse(course);
					scId.setStudent(student);
					
					Sc s = scc.doSelect(scId);
	
					if(s == null){
						//û�����ѧ����ѧ����Ϣ�У��������Ϣ��û��ȱ���Ż�������ѧ��,
		
						sc.setId(scId);
						
						//����ѡ�α�
						scc.doInsert(sc);
							
						success ++;
					}else{
						failth ++;
					}
				}
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(fileType.equals("xls")){
			try {
				List<String> list = se.readXlsx(path, sheet);
				if(list == null){
					return false;
				}
				for(int i = 0; i < list.size(); i++){
					String sid = list.get(i);
					
					Sc sc = new Sc();
					ScId scId = new ScId();
						
					CourseCRUD courseCRUD = new CourseCRUD();
					Course course = courseCRUD.doSelect(cid);
						
					StuCRUD stuCRUD = new StuCRUD();
					Student student = stuCRUD.doSelect(sid);
						
					scId.setCourse(course);
					scId.setStudent(student);
					
					Sc s = scc.doSelect(scId);
					if(s == null){
						//û�����ѧ����ѧ����Ϣ�У��������Ϣ��û��ȱ���Ż�������ѧ��,
						sc.setId(scId);
						//����ѡ�α�
						scc.doInsert(sc);
							
						success ++;
					}else{
						failth ++;
					}
				}
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
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
