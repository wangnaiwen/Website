package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuCRUD;
import dao.TeaCRUD;

import entity.Student;
import entity.Teacher;

public class Register extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Destruction of the servlet. <br>
	 */
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

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String passwd = request.getParameter("password");
		String type = request.getParameter("picRegType");
		
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		
		System.out.println("++++++++++++++++++++++++++++++++  "+id+"  " +name+"  "+passwd);
		
		if(id.equals("") || passwd.equals("")){
			//��ʾid�����붼����Ϊ��
			response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error1=yes");
		}else{
			if(type.equals("student")){
				//ע��һ��ѧ��
				boolean check = registerStudent(id, name, passwd);
				if(check){
					//ע���ύ֮��Ӧ����ʾ�û�ע����Ϣ���ύ���ȴ�����Ա���
					response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error2=yes");
				}else{
					//���û��Ѿ�����
					response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error3=yes");
				}
			}else{
				//ע��һ����ʦ
				boolean check=registerTeacher(id, name, passwd);
				if(check){
					//ע���ύ֮��Ӧ����ʾ�û�ע����Ϣ���ύ���ȴ�����Ա���
					response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error2=yes");
				}else{
					//���û��Ѿ�����
					response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error3=yes");
				}
			}
			
		}
		out.print("yes");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	//ѧ��ע��, ��������Ա��ˣ�type==1;����Ϊ0
	private boolean registerStudent(String id, String name,  String passwd){
		Student stu = new Student();
		StuCRUD sc = new StuCRUD();
		Student stu2 = sc.doSelect(id);
		if(stu2 != null){
			//�Ѿ����ڸ��û�
			return false;
		}else{
			stu.setSid(id);
			stu.setName(name);
			stu.setPassword(passwd);
			stu.setType(0);
			sc.doInsert(stu);
			return true;
		}
	}
	
	//��ʦע��, ��������Ա��ˣ�type==1;����Ϊ0
	private boolean registerTeacher(String id, String name, String passwd){
		Teacher teacher = new Teacher();
		TeaCRUD tc = new TeaCRUD();
		Teacher t2 = tc.doSelect(id);
		if(t2 != null){
			return false;
		}else{
			teacher.setTid(id);
			teacher.setName(name);
			teacher.setPassword(passwd);
			teacher.setType(0);
			tc.doInsert(teacher);
			return true;
		}
		
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
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
	}

}
