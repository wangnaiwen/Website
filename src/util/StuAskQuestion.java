package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseCRUD;
import dao.QuestionCRUD;
import dao.StuCRUD;
import entity.Course;
import entity.Question;
import entity.QuestionId;
import entity.Student;

public class StuAskQuestion extends HttpServlet {

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
		
		String cid = request.getParameter("cid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		title = new String(title.getBytes("ISO-8859-1"),"utf-8");
		content = new String(content.getBytes("ISO-8859-1"),"utf-8");
		
		title = title.trim();
		content = content.trim();
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		
		if(title.isEmpty() || content.isEmpty()){
			//提示用户问题和问题的描述不能为空
			out.println("<script>alert('问题以及问题的描述都不能为空！'); history.back();</script>");
		}else{
			QuestionCRUD queCRUD = new QuestionCRUD();
			List<Question> queList = queCRUD.doSelectByCid(cid);
			int qno;
			if(queList == null){
				qno = 1;
			}else{
				if(queList.size() == 0){
					qno = 1;
				}else{
					qno = queList.size()+1;
				}
			}
			QuestionId quId = new QuestionId();
			quId.setQno(qno);
			
			CourseCRUD couCRUD = new CourseCRUD();
			Course course = couCRUD.doSelect(cid);
			quId.setCourse(course);
			
			String sid = Who.getStudent();
			StuCRUD stuCRUD = new StuCRUD();
			Student student = stuCRUD.doSelect(sid);
			
			Question question = new Question();
			question.setId(quId);
			question.setTitle(title);
			
		
			question.setStudent(student);
			question.setTime(time);
			question.setTitle(title);
			question.setDescription(content);
			
			queCRUD.doInsert(question);
			
			//提示插入成功，并且跳回主页
			request.getRequestDispatcher("/studentScanForum.jsp").forward(request, response);
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
