package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScCRUD;
import entity.Sc;

public class InsertScoreForCourse extends HttpServlet {

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
		
		ScCRUD scCRUD = new ScCRUD();
		List<Sc> scLists = scCRUD.doSelectByCID(cid);
		if(scLists == null){
			//���κ���Ҫ�ύ������
			out.println("<script>alert('���κ����ݼ�¼'); history.back();</script>");
		}else{
			int counts = scLists.size();
			String scores[] = new String[counts]; 
			for(int i = 0; i <counts; i++){
				scores[i] = request.getParameter(""+i);
			}
			
			for(int i = 0; i < counts; i++){
				Sc sc = scLists.get(i);
				String score = scores[i];
				score = score.trim();
				boolean isNum = score.matches("[0-9]+");
				if(isNum){
					int s = Integer.parseInt(score);
					if(s < 0 || s > 100){
						//���ﲻ������
					}else{
						//��������������Ҫ���
						sc.setScore(s);
					}
				}else{
					//�������֣��ж��ַ��ĳ���
					if(score.isEmpty()){
						//˵���û������ֵ��Ϊ��
						sc.setScore(null);
					}
					
				}
				scCRUD.doModify(sc);
			}
			//��ת����ҳ
			request.getRequestDispatcher("/teacherInsertScore.jsp").forward(request, response);
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
