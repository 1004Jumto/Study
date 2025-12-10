package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("로그인 init 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println(String.format("아이디: %s \n 비번: %s", user_id, user_pw));
		
		String[] subject = request.getParameterValues("subject");
		System.out.println("선택과목: " + Arrays.toString(subject));
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		
		// 서블릿 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		String data = "<html>";
		data += "<body>";
		data += "아이디: " + user_id + "<br>";
		data += "패스워드: " + pw;
		data += "</body>";
		data += "</html>";
		pw.print(data);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
