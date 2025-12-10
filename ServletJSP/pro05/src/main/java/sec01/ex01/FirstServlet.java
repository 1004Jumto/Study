package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	@Override
	public void init() throws ServletException{
		System.out.println("init 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet 호출");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print("<html><body><h1>안녕하세요!</h1></body></html>");
		pw.close();
	}
	

	@Override
	public void destroy() {
		System.out.println("destroy 호출");
	}
}
