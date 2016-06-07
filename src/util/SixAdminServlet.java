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

public class SixAdminServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		//必填部分
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String passwd = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		
		//教师和学生选填公共部分
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String phoneNumber = request.getParameter("phoneNum");
		String qq = request.getParameter("qq");
		String wechat = request.getParameter("wechat");
		
		//学生选填部分
		String department = request.getParameter("department");
		String major = request.getParameter("major");
		
		department = new String(department.getBytes("ISO-8859-1"),"utf-8");
		major = new String(major.getBytes("ISO-8859-1"),"utf-8");
		
		//教师选填部分
		String grade = request.getParameter("grade");
		String abstracts = request.getParameter("abstracts");
		
		grade = new String(grade.getBytes("ISO-8859-1"),"utf-8");
		abstracts = new String(abstracts.getBytes("ISO-8859-1"),"utf-8");
		
		if(id.equals("") || name.equals("") || passwd.equals("")){
			//提示不能三者都不能为空
			response.sendRedirect("http://localhost:8081/1300310118/sixAdmin.jsp?error1=yes");
		}else{
			if(userType.equals("teacher")){
				Teacher teacher = new Teacher();
				teacher.setTid(id);
				teacher.setName(name);
				teacher.setPassword(passwd);
				teacher.setType(1);
				
				teacher.setBirthday(birthday);
				teacher.setSex(sex);
				teacher.setPhoneNumber(phoneNumber);
				teacher.setQq(qq);
				teacher.setWechat(wechat);
				
				teacher.setGrade(grade);
				teacher.setAbstracts(abstracts);
				
				boolean check = loginTeacher(teacher);
				if(check){
					response.sendRedirect("http://localhost:8081/1300310118/sixAdmin.jsp?success=yes");
				}else{
					response.sendRedirect("http://localhost:8081/1300310118/sixAdmin.jsp?error2=yes");
				}
			}else if(userType.equals("student")){
				Student student = new Student();
				
				student.setSid(id);
				student.setName(name);
				student.setPassword(passwd);
				student.setType(1);
				
				student.setBirthday(birthday);
				student.setSex(sex);
				student.setPhoneNumber(phoneNumber);
				student.setQq(qq);
				student.setWechat(wechat);
				
				student.setDepartment(department);
				student.setMajor(major);
				
				boolean check = loginStudent(student);
				if(check){
					response.sendRedirect("http://localhost:8081/1300310118/sixAdmin.jsp?success=yes");
				}else{
					response.sendRedirect("http://localhost:8081/1300310118/sixAdmin.jsp?error2=yes");
				}
			}
			
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	private boolean loginTeacher(Teacher teacher){
		TeaCRUD tc = new TeaCRUD();
		Teacher tea = tc.doSelect(teacher.getTid());
		if(tea != null){
			return false;
		}else{
			tc.doInsert(teacher);
			return true;
		}
		
	}
	
	private boolean loginStudent(Student student){
		StuCRUD sc = new StuCRUD();
		Student stu = sc.doSelect(student.getSid());
		if(stu != null){
			return false;
		}else{
			sc.doInsert(student);
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
