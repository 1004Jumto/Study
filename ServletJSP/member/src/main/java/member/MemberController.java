package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 
		String searchWord = request.getParameter("searchWord");
		MemberVO vo = new MemberVO();
		vo.setName(searchWord);
 
		// MemeberDAO 호출
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers(vo);
		
		// 값 저장
		request.setAttribute("list", list);
		request.setAttribute("vo", vo);
		
		// JSP 포워딩
		request
			.getRequestDispatcher("/WEB-INF/view/member/member.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
