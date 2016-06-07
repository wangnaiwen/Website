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
			//提示id和密码都不能为空
			response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error1=yes");
		}else{
			if(type.equals("student")){
				//注册一个学生
				boolean check = registerStudent(id, name, passwd);
				if(check){
					//注册提交之后，应该提示用户注册信息已提交，等待管理员审核
					response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error2=yes");
				}else{
					//该用户已经存在
					response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error3=yes");
				}
			}else{
				//注册一个老师
				boolean check=registerTeacher(id, name, passwd);
				if(check){
					//注册提交之后，应该提示用户注册信息已提交，等待管理员审核
					response.sendRedirect("http://localhost:8081/1300310118/register.jsp?error2=yes");
				}else{
					//该用户已经存在
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
	
	//学生注册, 经过管理员审核，type==1;否则为0
	private boolean registerStudent(String id, String name,  String passwd){
		Student stu = new Student();
		StuCRUD sc = new StuCRUD();
		Student stu2 = sc.doSelect(id);
		if(stu2 != null){
			//已经存在该用户
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
	
	//老师注册, 经过管理员审核，type==1;否则为0
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
