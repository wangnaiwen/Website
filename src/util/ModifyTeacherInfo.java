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

public class ModifyTeacherInfo extends HttpServlet {

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
		String birthday = request.getParameter("birthday");
		String grade = request.getParameter("grade");
		String abstracts = request.getParameter("abstracts");
		String phoneNum = request.getParameter("phoneNum");
		String qq = request.getParameter("qq");
		String wechat = request.getParameter("wechat");
		String sex = request.getParameter("sex");
		String userType = request.getParameter("type");
		
		String save = request.getParameter("save");
		String cancel = request.getParameter("cancel");
		
		//ÅÐ¶ÏÐÔ±ð
		if(sex.equals("0")){
			sex = "woman";
		}else if(sex.equals("1")){
			sex = "man";
		}else{
			sex = "";
		}
		
		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		grade = new String(grade.getBytes("ISO-8859-1"),"utf-8");
		abstracts = new String(abstracts.getBytes("ISO-8859-1"),"utf-8");
		sex = new String(sex.getBytes("ISO-8859-1"),"utf-8");
		
		if(save != null){
			if(name.equals("") || passwd.equals("")){
				response.sendRedirect("http://localhost:8081/1300310118/modifyTeacherInfo.jsp?error1=yes");
			}else{
				Teacher tea = new Teacher();
				TeaCRUD tc = new TeaCRUD();
				
				tea.setTid(id);
				tea.setName(name);
				tea.setPassword(passwd);
				tea.setBirthday(birthday);
				tea.setGrade(grade);
				tea.setAbstracts(abstracts);
				tea.setPhoneNumber(phoneNum);
				tea.setQq(qq);
				tea.setSex(sex);
				tea.setWechat(wechat);
				tea.setType(Integer.parseInt(userType));
				tc.doModify(tea);
				
				request.getRequestDispatcher("/fourAdmin.jsp").forward(request, response);
			}
		}
		if(cancel != null){
			request.getRequestDispatcher("/fourAdmin.jsp").forward(request, response);
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
