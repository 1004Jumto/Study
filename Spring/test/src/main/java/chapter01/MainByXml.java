package chapter01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		// xml을 읽어들이고 빈 객체 생성 및 등록(컨테이너에 저장)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter01/beans.xml");
		
		Person p = (Person)ctx.getBean("person");
		System.out.println(p);
		
//		Person p2 = (Person)ctx.getBean("person");
		Person p2 = ctx.getBean("person", Person.class);
		System.out.println(p == p2);
		
//		Person p3 = new Person(); 	지금까지 해오던 방식
	}

}
