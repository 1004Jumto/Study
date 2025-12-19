package chapter04;

import org.springframework.stereotype.Component;

@Component		// 부품, 자동으로 Bean 생성
public class BoardDAO {
	public void list() {
		System.out.print("목록 조회");
	}
}
