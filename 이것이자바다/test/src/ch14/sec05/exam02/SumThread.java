package ch14.sec05.exam02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumThread extends Thread {
	private long sum;

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			sum += i;
			System.out.println("current Sum = " + sum);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
