package chapter06_1.aop;

public class CalculatorImpl2 implements Calculator {

	@Override
	public long factorial(int n) {
		
		if(n == 1) return 1;
		return n * factorial(n - 1);
		
		
	}


}
