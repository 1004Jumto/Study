package kr.co.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public MemberVO login(MemberVO vo) {
		MemberVO memberVO = mapper.login(vo);
		
		if(memberVO == null) {
			
		} else {
			
		}
		
		return memberVO;
	}
 

	@Override
	public boolean join(MemberVO vo) {
		int ret = mapper.join(vo);
		
		if(ret > 0) {
			return true;
		}
				
		return false;
	}

	@Override
	public int checkEmail(String email) {
		int ret = mapper.emailCheck(email);
		if(ret > 0) {
			// 이미 존재하는 이메일
		}
		
		return ret;
	}


}
