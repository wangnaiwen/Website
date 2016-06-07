package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuCRUD;
import dao.TeaCRUD;
import entity.Student;
import entity.Teacher;

public class SecondAdminServlet extends HttpServlet {

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
		
		TeaCRUD tc = new TeaCRUD();
		List<Teacher> list = tc.doSelectByType(0);
		String radios[] = new String[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			radios[i] = request.getParameter(""+i);
		}
		
		String submit1 = request.getParameter("submit");
		String submit2 = request.getParameter("agreeAll");
		String submit3 = request.getParameter("refuseAll");
		
		if(submit1 != null){
			//�Ҵ�ѡ�ⲿ�ֵ�ͬѧ��Ȼ��ͬ���ѧ��type=1, ����s����Ϊ3
			for(int i = 0; i < list.size(); i++){
				if(radios[i] != null){
					if(radios[i].equals("yes")){
						Teacher tea = list.get(i);
						tea.setType(1);
						tc.doModify(tea);
					}else if(radios[i].equals("no")){
						Teacher tea = list.get(i);
						tea.setType(3);
						tc.doModify(tea);
					}
				}
			}
			request.getRequestDispatcher("/secondAdmin.jsp").forward(request, response);
		}
		if(submit2 != null){
			//����ȫ����ѧ����type=1�� ����ͨ�����
			System.out.println("***********************ȫ��ͬ��");
			for(int i = 0; i < list.size(); i++){
				Teacher tea = list.get(i);
				tea.setType(1);
				tc.doModify(tea);
			}
			request.getRequestDispatcher("/secondAdmin.jsp").forward(request, response);
		}
		if(submit3 != null){
			//����ȫ����ѧ����type=3������ܾ�����
			System.out.println("***********************ȫ���ܾ�");
			for(int i = 0; i < list.size(); i++){
				Teacher tea = list.get(i);
				tea.setType(3);
				tc.doModify(tea);
			}
			request.getRequestDispatcher("/secondAdmin.jsp").forward(request, response);
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
