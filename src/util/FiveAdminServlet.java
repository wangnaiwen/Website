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
import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import controler.StuExcelCon;
import controler.TeaExcelCon;
import dao.StuCRUD;
import dao.TeaCRUD;
import entity.Student;
import entity.Teacher;

public class FiveAdminServlet extends HttpServlet {

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
		
		
		
		// 准备上传目录
//		String path = this.getServletContext().getRealPath("images");
		String path = "E:\\upload";
		
		File fpath = new File(path);
		if(!fpath.exists()){
			fpath.mkdir();
		}
		
		// 实例化组件
		SmartUpload su = new SmartUpload("utf-8");
		
		//IpTimeStamp its=new IpTimeStamp(InetAddress.getLocalHost().getHostAddress());//request.getRemoteAddr()获得用户的ip地址
		
		// 初始化组件
		su.initialize(this.getServletConfig(), request, response);
		
		try {
			
			// 限定文件类型：xlsx
			su.setAllowedFilesList("xlsx, xls");   //可以不限定
			//su.setMaxFileSize(50*1024); // 不能超过50K
			
			// 上传并提取文件
			su.upload();
			SmartFile file = su.getFiles().getFile(0);
			
			// 生成文件名
			/**
			 * file.getFilePathName()是：获得绝对路径
			 * */
			
			String fname = file.getFilePathName();
			
			//System.out.println(file.getFilePathName()+"		"+file.getFileExt()+"	"+file.getFieldName());
			
			//String fname = new Date().getTime()+"."+file.getFileExt();
			
			// 保存文件
			//file.saveAs(path);
			//file.saveAs(path+"/"+fname);
			String absoluPath = path + "/" + fname;
			file.saveAs(absoluPath);
			
			// 提示
			//out.println("<script>alert('文件上传成功！');location.href='upload.jsp';</script>");
			
			// 提取字段信息
			//String username = su.getRequest().getParameter("username");
			
			String userType = su.getRequest().getParameter("userType");
			String sheet = su.getRequest().getParameter("sheet");
			
			
			// 进行数据库操作
			//1.文件名  2.文件路径   
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!"+sheet+"	"+ "	"+userType+"	"+fname);
			
			//获取文件的类型
			String fileType = file.getFileExt(); 
			
			if(userType.equals("teacher")){
				boolean juede = insertAllTeacher(absoluPath, sheet, fileType);
				if(juede){
					//out.println("<script>alert('成功'"+success+"'条记录！失败'" + failth +"'记录');location.href='fiveAdmin.jsp';</script>");
					String hint = "成功"+success+"条，失败"+failth+"条！";
					out.println("<script>alert('"+ hint +"');history.back();</script>");
				}else{
					out.println("<script>alert('找不到任何记录'); history.back();</script>");
				}
			}else{
				boolean juede = insertAllStudent(absoluPath, sheet, fileType);
				if(juede){
					//out.println("<script>alert('成功'"+success+"'条记录！失败'" + failth +"'记录');location.href='fiveAdmin.jsp';</script>");
					String hint = "成功"+success+"条，失败"+failth+"条！";
					out.println("<script>alert('"+ hint +"');history.back();</script>");
				}else{
					out.println("<script>alert('找不到任何记录'); history.back();</script>");
				}
			}
			
		} catch(SecurityException e){
			out.println("<script>alert('只能从xlsx, xls的文件中批量插入数据！');history.back();</script>");
			e.printStackTrace();
		}
		catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			out.println("<script>alert('文件上传失败！');history.back();</script>");
			e.printStackTrace();
		}
		
	}

	private boolean insertAllStudent(String path, String sheet, String fileType){
		StuCRUD sc = new StuCRUD();
		StuExcelCon se = new StuExcelCon();
		if(fileType.equals("xlsx")){
			try {
				List<Student> students = se.readXlsx(path, sheet);
				if(students == null){
					return false;
				}
				for(int i = 0; i < students.size(); i++){
					Student stu = students.get(i);
					Student s = sc.doSelect(stu.getSid());
					if(s == null){
						//没有这个学生，学生信息中，必填的信息都没有缺，才会插入这个学生,
						System.out.println("QQQQQQQQQQQQQQ"+stu.getPassword()+"QQ");
						if((!stu.getSid().equals(" ")) && (!stu.getName().equals(" "))
								&& (!stu.getPassword().equals(" ")) && (stu.getType()!=null)){
							sc.doInsert(stu);
							success ++;
						}else{
							failth ++;
						}
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
				List<Student> students = se.readXls(path, sheet);
				if(students == null){
					return false;
				}
				for(int i = 0; i < students.size(); i++){
					Student stu = students.get(i);
					Student s = sc.doSelect(stu.getSid());
					if(s == null){
						//没有这个学生，学生信息中，必填的信息都没有缺，才会插入这个学生,
						if(!stu.getSid().equals("") && !stu.getName().equals("") 
								&& !stu.getPassword().equals("") && !stu.getType().equals("")){
							sc.doInsert(stu);
							success ++;
						}else{
							failth ++;
						}
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
	
	private boolean insertAllTeacher(String path, String sheet, String fileType){
		TeaExcelCon te = new TeaExcelCon();
		TeaCRUD tc = new TeaCRUD();
		if(fileType.equals("xlsx")){
			try {
				List<Teacher> teachers = te.readXlsx(path, sheet);
				if(teachers == null){
					return false;
				}
				for(int i = 0; i < teachers.size(); i++){
					Teacher tea = teachers.get(i);
					Teacher s = tc.doSelect(tea.getTid());
					if(s == null){
						//没有这个学生，学生信息中，必填的信息都没有缺，才会插入这个学生,
						System.out.println("QQQQQQQQQQQQQQ"+tea.getPassword()+"QQ");
						if((!tea.getTid().equals(" ")) && (!tea.getName().equals(" "))
								&& (!tea.getPassword().equals(" ")) && (tea.getType()!=null)){
							tc.doInsert(tea);
							success ++;
						}else{
							failth ++;
						}
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
				List<Teacher> teachers = te.readXls(path, sheet);
				if(teachers == null){
					return false;
				}
				for(int i = 0; i < teachers.size(); i++){
					Teacher tea = teachers.get(i);
					Teacher t = tc.doSelect(tea.getTid());
					if(t == null){
						//没有这个教师，教师信息中，必填的信息都没有缺，才会插入这个教师,
						if(!tea.getTid().equals("") && !tea.getName().equals("") 
								&& !tea.getPassword().equals("") && !tea.getType().equals("")){
							tc.doInsert(tea);
							success ++;
						}else{
							failth ++;
						}
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
