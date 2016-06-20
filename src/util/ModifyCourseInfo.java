package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.CourseCRUD;
import dao.StuCRUD;
import dao.TeaCRUD;
import entity.Course;
import entity.Student;
import entity.Teacher;

public class ModifyCourseInfo extends HttpServlet {

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
		String code = request.getParameter("code");
		String duration = request.getParameter("duration");
		String expDuration = request.getParameter("expDuration");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String teacherId = request.getParameter("teacherId");
		String type = request.getParameter("type");
		
		
		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		type = new String(type.getBytes("ISO-8859-1"),"utf-8");
		
		String save = request.getParameter("save");
		String cancel = request.getParameter("cancel");
		
		if(save != null){
			if(id.isEmpty() || name.isEmpty() || type.isEmpty() || code.isEmpty() || duration.isEmpty() 
					|| expDuration.isEmpty() || startTime.isEmpty() || endTime.isEmpty() || teacherId.isEmpty()){
				//弹出脚本说：这几项都不准为空
				out.println("<script>alert('这几项都不准为空！'); history.back();</script>");
			}else{
				
				TeaCRUD tc = new TeaCRUD();
				Teacher teacher = tc.doSelect(teacherId);
				if(teacher == null){
					//说明不存在这个教师
					out.println("<script>alert('不存在这个教师！'); history.back();</script>");
				}else{
					CourseCRUD cc = new CourseCRUD();
					Course cou = new Course();
					cou.setId(id);
					
					cou.setCourseCode(code);
					cou.setCourseType(type);
					cou.setCourseName(name);
					cou.setCourseDuration(Integer.parseInt(duration));
					cou.setCourseExpDuration(Integer.parseInt(expDuration));
					cou.setCourseStartDate(startTime);
					cou.setCourseEndDate(endTime);
					cou.setTeacher(teacher);
					cou.setTeacherName(teacher.getName());
					
					cc.doModify(cou);
					//response.sendRedirect("http://localhost:8081/1300310118/modifyCourseInfo.jsp?success=yes");
					request.getRequestDispatcher("/eightAdmin.jsp").forward(request, response);
				}
			}
		}
		if(cancel != null){
			request.getRequestDispatcher("/eightAdmin.jsp").forward(request, response);
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
