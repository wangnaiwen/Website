package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuCRUD;

import entity.Admin;
import entity.AdminDAO;
import entity.Student;
import entity.StudentDAO;
import entity.Teacher;
import entity.TeacherDAO;

public class Login extends HttpServlet {

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

		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String id = request.getParameter("userid");
		String passwd = request.getParameter("password");
		String type = request.getParameter("loginType");
		
		Admin admin;
		Student stu;
		Teacher tea;
		
		AdminDAO ad = null;
		StudentDAO sd = null;
		TeacherDAO td = null;
		
		
		if(type.equals("admin")){
			ad = new AdminDAO();
			admin = ad.findById(id);
			if(admin == null){
				//������û������˺�
				response.sendRedirect("http://localhost:8081/1300310118/index.jsp?error1=yes");
			}else{
				if(admin.getPassword().equals(passwd)){
					//��֤�ɹ�����ת����ҳ
					request.getRequestDispatcher("/firstAdmin.jsp").forward(request, response);
					/*List<Student> list = null;
					StuCRUD sc = new StuCRUD();
					list = sc.doSelectByType(0);
					System.out.println("*****************"+list.get(0).getSid()+"	"+list.get(0).getPassword());*/
				}else{
					//˵�����������
					response.sendRedirect("http://localhost:8081/1300310118/index.jsp?error2=yes");
				}
			}
		}else if(type.equals("student")){
			sd = new StudentDAO();
			stu = sd.findById(id);
			if(stu == null){
				//û�����ѧ��
				//response.sendRedirect("http://localhost:8081/1300310118/index.jsp?error1=yes");
			}else{
				if(!stu.getPassword().equals(passwd)){
					//˵���������
					response.sendRedirect("http://localhost:8081/1300310118/index.jsp?error2=yes");
				}else if(stu.getPassword().equals(passwd) && stu.getType()==1){
					//˵����֤����ɹ����������Ѿ���������Ա���
					
				}else{
					//˵����������ȷ������û�о����������
					response.sendRedirect("http://localhost:8081/1300310118/index.jsp?error3=yes");
				}
			}
		}else{
			td = new TeacherDAO();
			tea = td.findById(id);
			if(tea == null){
				//û������˺�
				//response.sendRedirect("http://localhost:8081/1300310118/index.jsp?error1=yes");
			}else{
				if(!tea.getPassword().equals(passwd)){
					//˵���������
					response.sendRedirect("http://localhost:8081/1300310118/index.jsp?error2=yes");
				}else if(tea.getPassword().equals(passwd) && tea.getType() == 1){
					//˵����֤����ɹ�����������˺��Ѿ�������Ա���ͨ��
					
				}else{
					//˵������ɹ�������û�þ�������Ա���
					response.sendRedirect("http://localhost:8081/1300310118/index.jsp?error3=yes");
				}
			}
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	private List<Student> getStudents(){
		List<Student> list = null;
		return list;
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
