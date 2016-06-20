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

import dao.AnswerCRUD;
import dao.CourseCRUD;
import dao.QuestionCRUD;
import dao.StuCRUD;
import entity.Answer;
import entity.AnswerId;
import entity.Course;
import entity.Question;
import entity.QuestionId;
import entity.Student;

public class DetailOfQuestion extends HttpServlet {

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
		String qno1 = request.getParameter("qno");
		int qno = Integer.parseInt(qno1);
		String content = request.getParameter("content");
		
		content = new String(content.getBytes("ISO-8859-1"),"utf-8");
		content = content.trim();
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		
		String sid = Who.getStudent();
		
		if(content.isEmpty()){
			//提示回复不能为空
			out.println("<script>alert('回复不能为空！'); history.back();</script>");
		}else{
			//在这里面插入
			AnswerCRUD  anCRUD = new AnswerCRUD();
			Answer answer = new Answer();
			AnswerId anId = new AnswerId();
			
			QuestionCRUD queCRUD = new QuestionCRUD();
			QuestionId quId = new QuestionId();
			CourseCRUD courseCRUD = new CourseCRUD();
			Course course = courseCRUD.doSelect(cid);
			quId.setQno(qno);
			quId.setCourse(course);
			Question question = queCRUD.doSelect(quId);
			
			List<Answer> anList = anCRUD.doSelectByCIDQNO(cid, qno);
			int anCount = 0;
			if(anList == null){
				anCount = 0;
			}else{
				anCount = anList.size();
			}
			anId.setQuestion(question);
			anId.setAno(anCount+1);
			
			StuCRUD stuCRUD = new StuCRUD();
			Student student = stuCRUD.doSelect(sid);
			answer.setId(anId);
			answer.setContent(content);
			answer.setTime(time);
			answer.setStudent(student);
			
			anCRUD.doInsert(answer);
			
			//在这里跳转到当前页面，刷新
			request.getRequestDispatcher("/detailOfQuestion.jsp?cid="+cid+"&qno="+qno).forward(request, response);
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
