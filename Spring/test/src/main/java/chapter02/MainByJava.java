package chapter02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		
		
		MemberService service = ctx.getBean("memberService", MemberService.class);
		service.regist();

	}

}
