package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/show")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Boolean isLogon = false;
		String id = "", pwd = "";
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			isLogon = (Boolean)session.getAttribute("isLogon");
			if(isLogon == true) {
				id = (String)session.getAttribute("login.id");
				pwd = (String)session.getAttribute("login.pwd");
				out.print("<html><body>");
				out.print("아이디: " + id + "<br>");
				out.print("비밀번호: " + pwd + "<br>");
				out.print("</body></html>");
			}else {
				response.sendRedirect("login3.html");
			}
		}else {
			response.sendRedirect("login3.html");
		} 
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
