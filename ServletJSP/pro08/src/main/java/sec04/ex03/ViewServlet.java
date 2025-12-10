package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/viewMembers")
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
		
		List<MemberVO> memList = (List)request.getAttribute("membersList");
		
		out.print("<html><body>");		
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td>");
		for(MemberVO vo: memList) {
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
		out.print("<a href='/pro08/memberForm.html'>새 회원 등록하기</a>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
