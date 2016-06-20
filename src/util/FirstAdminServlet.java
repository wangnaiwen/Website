package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuCRUD;
import entity.Student;

public class FirstAdminServlet extends HttpServlet {

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
		
		StuCRUD sc = new StuCRUD();
		List<Student> list = sc.doSelectByType(0);
		String radios[] = new String[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			radios[i] = request.getParameter(""+i);
		}
		
		String submit1 = request.getParameter("submit");
		String submit2 = request.getParameter("agreeAll");
		String submit3 = request.getParameter("refuseAll");
		
		if(submit1 != null){
			//找打勾选这部分的同学，然后同意的学生type=1, 否者s设置为3
			for(int i = 0; i < list.size(); i++){
				if(radios[i] != null){
					if(radios[i].equals("yes")){
						Student stu = list.get(i);
						stu.setType(1);
						sc.doModify(stu);
					}else if(radios[i].equals("no")){
						Student stu = list.get(i);
						stu.setType(3);
						sc.doModify(stu);
					}
				}
			}
			out.println("<script>alert('提交成功'); history.back();</script>");
		}
		if(submit2 != null){
			//设置全部的学生的type=1， 代表通过审核
			System.out.println("***********************全部同意");
			for(int i = 0; i < list.size(); i++){
				Student stu = list.get(i);
				stu.setType(1);
				sc.doModify(stu);
			}
			request.getRequestDispatcher("/firstAdmin.jsp").forward(request, response);
		}
		if(submit3 != null){
			//设置全部的学生的type=3，代表拒绝申请
			System.out.println("***********************全部拒绝");
			for(int i = 0; i < list.size(); i++){
				Student stu = list.get(i);
				stu.setType(3);
				sc.doModify(stu);
			}
			out.println("<script>alert('提交成功'); history.back();</script>");
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
