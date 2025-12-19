package chapter02;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO = new MemberDAO();
	
	public void setMemberDAO(MemberDAO dao) {
		this.memberDAO = dao;
	}
	
	@Override
	public void regist() {
		// 이전에는 MemberDAO에서 addMemeber 메소드 호출
		MemberDAO dao = new MemberDAO();
		
		// 스프링에서는 주입받은 MemberDAO 객체로 메소드 호출
		memberDAO.addMember();
	} 
}
