package chapter04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		
		BoardService service = ctx.getBean("boardServiceImpl", BoardServiceImpl.class);
		service.list();
		
		BoardController service2 = ctx.getBean("boardController", BoardController.class);
		service2.list();
	}

}
