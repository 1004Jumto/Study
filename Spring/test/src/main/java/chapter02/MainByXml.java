package chapter02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import chapter01.Person;

public class MainByXml {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter02/beans.xml");
		MemberService service = ctx.getBean("memberService", MemberService.class);
		    
		
		
	}
}
