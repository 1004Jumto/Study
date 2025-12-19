package chapter03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		
		MemberService service = ctx.getBean("memberService", MemberServiceImpl.class);
		service.regist();
	}

}
