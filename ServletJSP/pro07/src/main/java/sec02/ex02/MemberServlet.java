package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member3")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		doHandle(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		
		
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addMember")) {
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");
			MemberVO vo = new MemberVO();
			vo.setId(_id);
			vo.setEmail(_email);
			vo.setName(_name);
			vo.setPwd(_pwd);
			
			dao.addMember(vo);
		}
		else if(command.equals("delMember")) {
			String _id = request.getParameter("id");
			dao.delMember(_id);
		}
		
		
		// 출력
		List<MemberVO> list = dao.listMembers();
		out.print("<html><body>");		
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td>");
		for(MemberVO vo: list) {
			out.print("<tr>");
			out.print("<td>" + vo.getId() + "</td>");
			out.print("<td>" + vo.getPwd() + "</td>");
			out.print("<td>" + vo.getName() + "</td>");
			out.print("<td>" + vo.getEmail() + "</td>");
			out.print("<td>" + vo.getJoinDate() + "</td>"); 
			out.print("<td>" + "<a href='/pro07/member3?command=delMember&id=" + vo.getId() + "'>삭제</a></td></tr>"); 
			out.print("</tr>");
		}
		out.print("</table></html></body>");
		out.print("<a href='/pro07/memberForm.html'>새 회원 등록하기</a>");
	}

}
