package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuCRUD;
import entity.Student;

public class StudentPerfectInfo extends HttpServlet {

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

		String id = Who.getStudent();
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String birthday = request.getParameter("birthday");
		String department = request.getParameter("department");
		String major = request.getParameter("major");
		String phoneNum = request.getParameter("phoneNum");
		String qq = request.getParameter("qq");
		String wechat = request.getParameter("wechat");
		String sex = request.getParameter("sex");
		
		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		department = new String(department.getBytes("ISO-8859-1"),"utf-8");
		major = new String(major.getBytes("ISO-8859-1"),"utf-8");
		sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
		
		if(name.equals("")){
			out.println("<script>alert('姓名不能为空！'); history.back();</script>");
		}else{
			Student stu = new Student();
			StuCRUD sc = new StuCRUD();
			stu.setSid(id);
			stu.setName(name);
			stu.setPassword(passwd);
			stu.setBirthday(birthday);
			stu.setDepartment(department);
			stu.setMajor(major);
			stu.setPhoneNumber(phoneNum);
			stu.setQq(qq);
			stu.setSex(sex);
			stu.setWechat(wechat);
			stu.setType(1);
			sc.doModify(stu);
			out.println("<script>alert('修改成功！'); history.back();</script>");
		}

		
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
