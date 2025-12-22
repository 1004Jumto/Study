package chapter06_1.aop;

public class CalculatorImpl implements Calculator {

	@Override
	public long factorial(int n) {
//		long start = System.nanoTime();
		
		long result  = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}
		
		// 소요 시간
//		long end = System.nanoTime();
//		System.out.println("소요된 시간: " + (end - start));
		return result;
	}


}
