package chapter06_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter06_1.aop.Calculator;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Beans.class);
		
		Calculator calc = (Calculator) ctx.getBean("calculator");
		Calculator calc2 = (Calculator) ctx.getBean("calculator2");
		
		// 소요 시간
//		long start = System.nanoTime();
		
		long result = calc.factorial(5);
		long result2 = calc.factorial(15);
		
//		long end = System.nanoTime();
//		System.out.println("소요된 시간: " + (end - start));
		System.out.println("결과: " + result);
		System.out.println("결과: " + result2);
		
		System.out.println(calc.getClass().getName());
		System.out.println(calc2.getClass().getName());
	}
}
