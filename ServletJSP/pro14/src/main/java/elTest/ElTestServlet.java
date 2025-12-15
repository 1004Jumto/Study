package elTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ElTestServlet
 */
@WebServlet("/elTest")
public class ElTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/elTest");

		// 비즈니스 로직 처리
		// 출력값 저장
		
		// request - requestScope
		MemberVO vo = new MemberVO();
		vo.setName("만두");
		request.setAttribute("member", vo);
		
		
		// session - sessionScope
		HttpSession session = request.getSession();
		session.setAttribute("mem", vo);
		
//		우선순위는 request 먼저. 그다음 session
//		page > request > session 
		
		// 로그인 세션
		session.setAttribute("loginSession", vo);
		
		// 리스트안에 map을 넣어서 request 저장
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "제목1");		
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "제목2");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "제목3");
		list.add(map);
		request.setAttribute("list", list);
		
		
		// 응답(리다이렉트 || 포워딩)
		request.getRequestDispatcher("/elTest.jsp").forward(request, response);
		
	
	}

}
