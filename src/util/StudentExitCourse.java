package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseCRUD;
import dao.ScCRUD;
import dao.StuCRUD;
import entity.Course;
import entity.Sc;
import entity.ScId;
import entity.Student;

public class StudentExitCourse extends HttpServlet {

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

		String values[] = request.getParameterValues("exitCourse");
		String sid = Who.getStudent();
		
		
		//System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQ"+values.length);
		if(values == null ){
			//跳出：至少选中一项
			out.println("<script>alert('至少选中一项'); history.back();</script>");
			//response.sendRedirect("http://localhost:8081/1300310118/thirdAdmin.jsp?error1=yes");
		}else{
			//在这里进行删除
			for(int i = 0; i < values.length; i++){
				ScCRUD scc = new ScCRUD();
				
				CourseCRUD cc = new CourseCRUD();
				Course course = cc.doSelect(values[i]); 
				
				StuCRUD sc = new StuCRUD();
				Student student = sc.doSelect(sid);
				
				ScId scid = new ScId();
				scid.setCourse(course);
				scid.setStudent(student);
				
				Sc s = new Sc();
				s.setId(scid);
				
				scc.doDelete(s);
			}
			//out.println("<script>alert('提交成功'); history.back();</script>");
			request.getRequestDispatcher("/studentExitCourse.jsp").forward(request, response);
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
