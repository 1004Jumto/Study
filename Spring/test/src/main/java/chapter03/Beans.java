package chapter03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	@Bean
	public MemberDAO memberDao() {
		return new MemberDAOImpl();
	}
	
	@Bean
	public MemberDAO memberDao2() {
		return new MemberDAOImpl2();
	}	
	// 이렇게 같은 타입으로 인식하는 객체를 두 개 등록한 경우에 스프링은 어떤 객체를 주입해야하는지 모름
	// error: expected single matching bean but found 2: memberDao,memberDao2
	// 이런 경우, bean이름을 직접 지정할 수 있음
	
	@Bean
	public MemberService memberService() {
		MemberService memberService = new MemberServiceImpl();
		
		// DI 방식
		// memberService.setDao(memberDao());
		
		return memberService;
	}
}
