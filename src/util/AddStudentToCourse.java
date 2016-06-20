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

public class AddStudentToCourse extends HttpServlet {

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
		String sid = request.getParameter("id");
		
		String submit = request.getParameter("submit");
		String re = request.getParameter("return");
		
		//�ж����ѧ���ڲ�������α�����, ��û�����ѧ��
		if(submit != null){
			ScCRUD scc = new ScCRUD();
			StuCRUD sc = new StuCRUD();
			if(sid.isEmpty()){
				out.println("<script>alert('ѧ��ѧ�Ų�׼Ϊ�գ�'); history.back();</script>");
			}else{
				CourseCRUD courseCRUD = new CourseCRUD();
				Course course = courseCRUD.doSelect(cid);
				Student student = sc.doSelect(sid);
				
				if(student == null){
					//˵�����ѧ�Ż�û��ע��
					out.println("<script>alert('����ϵͳ�����ڸ�ѧ����'); history.back();</script>");
					
				}else{
					ScId scid = new ScId();
					Sc s = new Sc();
					
					scid.setCourse(course);
					scid.setStudent(student);
					
					if(scc.doSelect(scid) != null){
						//˵������γ��Ѿ������ѧ����
						out.println("<script>alert('�ÿγ��Ѿ��������ѧ����'); history.back();</script>");
					}else{
						//˵������γ�û�����ѧ��
						//�������潫ѡ����Ϣ���뵽ѡ�α���
						s.setId(scid);
						scc.doInsert(s);
							
						//����ɹ�����ת����
						out.println("<script>alert('��ѧ���ɹ�ѡ��γ̣�'); history.back();</script>");
					}
				}
			}				
		}
		if(re != null){
			request.getRequestDispatcher("/teacherCourse.jsp").forward(request, response);
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
