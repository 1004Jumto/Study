package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date date = new Date();
		Cookie coo = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍입니다.", "utf-8"));
//		coo.setMaxAge(24*60*60);
		coo.setMaxAge(-1);
		response.addCookie(coo);
		
		out.print("current Time: " + date);
		out.print("<br>문자열을 쿠키에 저장합니다");
		
		
		
	}

}
