package sec03.ex01;

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
@WebServlet("/loginTest")
public class LoginTestServlet extends HttpServlet {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println(String.format("아이디: %s \n 비번: %s", user_id, user_pw));

		String[] subject = request.getParameterValues("subject");
		System.out.println("선택과목: " + Arrays.toString(subject));

		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");

		System.out.println(String.format("아이디: %s \n 비번: %s \n 주소: %s", user_id, user_pw, user_address));

		// 서블릿 응답
		// ID 혹은 PW를 제대로 입력하지 않은 경우 오류 메세지 출력
		// 다시 로그인 창으로 이동
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(user_id != null && user_id.length() != 0) {
			if(user_id.equals("root")) {
				pw.print("<html>");
				pw.print("<body>");
				pw.print("<h1>관리자로 로그인 하셨습니다.</h1><br>");
				pw.print("<input type='button' value='회원정보 수정하기' />");
				pw.print("<input type='button' value='회원정보 삭제하기' />");
				pw.print("</body>");
				pw.print("</html>");
				
			}else {				
				pw.print("<html>");
				pw.print("<body>");
				pw.print(user_id + " 님 로그인 하셨습니다.<br>");
				pw.print("</body>");
				pw.print("</html>");
				
				String data = "<html>";
				data += "<body>";
				data += "아이디: " + user_id + "<br>";
				data += "패스워드: " + user_pw + "<br>";
				data += "주소: " + user_address;
				data += "</body>";
				data += "</html>";
				pw.print(data);
			}
		}else {
			pw.print("<html>");
			pw.print("<body>");
			pw.print("아이디를 입력하세요<br>");
			pw.print("<a href='http://localhost:8081/pro06/test01/login.html'>로그인창으로 이동</a>");
			pw.print("</body>");
			pw.print("</html>"); 
		}
		 
	}

}
