package kr.co.project.member;

public interface MemberService {
	MemberVO login(MemberVO vo);
	boolean join(MemberVO vo);
	int checkEmail(String email);
}
