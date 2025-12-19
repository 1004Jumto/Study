package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberServiceImpl implements MemberService {
	
	// 주입받는 객체, 주입되는 객체 둘 다 bean으로 등록 필요
	// 자동으로 주입
	@Autowired		// 타입 일치, 하위관계
	@Qualifier("memberDao2")
	private MemberDAO dao;
	
	@Override
	public void regist() { 
		dao.addMember();
	} 
}
