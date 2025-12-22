package chapter06_1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class TimerAdvice {
	
	@Pointcut("execution(public * chapter06_1.aop..)")
	public void timerTarget() {
		
	}
	
	@Around(value = "timerTarget()")  
	public Object invoke(ProceedingJoinPoint point) throws Throwable {
		// 메소드 실행 전
		System.out.println("메소드 실행 전");
		long start = System.nanoTime();
		Object obj = point.proceed();		// 주 기능
		
		// 메소드 실행 후
		System.out.println("메소드 실행 후");
		long end = System.nanoTime();
		
		// 소요시간
		System.out.println("소요시간: " + (end - start));
		return obj;
	}
}
