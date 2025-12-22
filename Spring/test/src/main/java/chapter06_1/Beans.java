package chapter06_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chapter06_1.aop.Calculator;
import chapter06_1.aop.CalculatorImpl;
import chapter06_1.aop.CalculatorImpl2;
import chapter06_1.aop.TimerAdvice;

@Configuration
@EnableAspectJAutoProxy
public class Beans {
	@Bean
	public Calculator calculator() {
		return new CalculatorImpl();
	}
	
	@Bean
	public Calculator calculator2() {
		return new CalculatorImpl2();
	}
	
	@Bean 
	public TimerAdvice timerAdvice() {
		return new TimerAdvice();
	}
}
