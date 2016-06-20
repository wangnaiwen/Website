package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubmitJobCRUD;
import entity.Submitjob;
import entity.SubmitjobId;

public class InsertScoreForJob extends HttpServlet {

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
		String sid = request.getParameter("sid");
		String ano1 = request.getParameter("ano");
		int ano = Integer.parseInt(ano1);
		String score1 = request.getParameter("score");
		
		//去掉后面的空格
		score1 = score1.trim();
		if(score1.isEmpty()){
			out.println("<script>alert('分数不能为空！'); history.back();</script>");
		}else{
			boolean isNum = score1.matches("[0-9]+"); 
			if(!isNum){
				//不是整数
				out.println("<script>alert('分数必须为整数！'); history.back();</script>");
			}else{
				int score = Integer.parseInt(score1);
				if(score > 100 || score < 0){
					//必须是0-100的整数
					out.println("<script>alert('分数必须为0-100的整数！'); history.back();</script>");
				}else{
					SubmitJobCRUD submitJobCRUD = new SubmitJobCRUD();
					
					SubmitjobId submitjobId = new SubmitjobId();
					submitjobId.setAno(ano);
					submitjobId.setCid(cid);
					submitjobId.setSid(sid);
					
					Submitjob submitjob = submitJobCRUD.doSelect(submitjobId);
					submitjob.setScore(score);
					submitJobCRUD.doModify(submitjob);
					//更新分数成功，跳转会前一页
					request.getRequestDispatcher("/lookAllSubmitJob.jsp?cid="+cid+"&ano="+ano).forward(request, response);
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
