package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.CourseCRUD;
import dao.TeaCRUD;
import entity.Course;
import entity.Teacher;

public class SevenAdminServlet extends HttpServlet {

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
		
		String cId = request.getParameter("cid");
		String cName = request.getParameter("cname");
		String cType = request.getParameter("ctype");
		String cCode = request.getParameter("ccode");
		String cDuration = request.getParameter("cduration");
		String cExpDuration = request.getParameter("cexpduration");
		String cStartTime = request.getParameter("cstarttime");
		String cEndTime = request.getParameter("cendtime");
		String cTeacher = request.getParameter("cteacher");
		
		
		cName = new String(cName.getBytes("ISO-8859-1"),"utf-8");
		cType = new String(cType.getBytes("ISO-8859-1"),"utf-8");
		cCode = new String(cCode.getBytes("ISO-8859-1"),"utf-8");
		cTeacher = new String(cTeacher.getBytes("ISO-8859-1"),"utf-8");
		
		if(cId.isEmpty() || cName.isEmpty() || cType.isEmpty() || cCode.isEmpty() || cDuration.isEmpty() 
				|| cExpDuration.isEmpty() || cStartTime.isEmpty() || cEndTime.isEmpty() || cTeacher.isEmpty()){
			//弹出脚本说：这几项都不准为空
			out.println("<script>alert('这几项都不准为空！'); history.back();</script>");
		}else{
			//查，存不存在这个课程，存不存在这个老师
			CourseCRUD cc = new CourseCRUD();
			Course course = cc.doSelect(cId);
			if(course != null){
				//已经有这个课号了
				out.println("<script>alert('该课号已经存在！'); history.back();</script>");
			}else{
				TeaCRUD tc = new TeaCRUD();
				Teacher teacher = tc.doSelect(cTeacher);
				if(teacher == null){
					//说明不存在这个教师
					out.println("<script>alert('不存在这个教师！'); history.back();</script>");
				}else{
					
					Course cou = new Course();
					cou.setId(cId);
					
					cou.setCourseCode(cCode);
					cou.setCourseType(cType);
					cou.setCourseName(cName);
					cou.setCourseDuration(Integer.parseInt(cDuration));
					cou.setCourseExpDuration(Integer.parseInt(cExpDuration));
					cou.setCourseStartDate(cStartTime);
					cou.setCourseEndDate(cEndTime);
					cou.setTeacher(teacher);
					cou.setTeacherName(teacher.getName());
					//cou.setTeacher(teacher)；
					
					cc.doInsert(cou);
					//插入成功
					response.sendRedirect("http://localhost:8081/1300310118/sevenAdmin.jsp?success=yes");
				}
			}
			
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
