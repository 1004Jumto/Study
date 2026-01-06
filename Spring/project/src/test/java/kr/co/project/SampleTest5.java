package kr.co.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Mockito 테스트")
@ExtendWith(MockitoExtension.class)
public class SampleTest5 {
	@Mock
	SampleObject mockObject;
	
	@Test
	@DisplayName("Mock 테스트")
	public void mockTest() {
		String result = mockObject.getName();
		// 검증
        assertNull(result);
        System.out.println(result);
	}
	
	@Spy
	SampleObject spyObject;
	
	@Test
	@DisplayName("Spy를 사용한 게시판 목록 조회 테스트")
	public void spyTest() {
		String result = spyObject.getName();
		// 검증
        assertNotNull(result);
        System.out.println(result);
	}

}

class SampleObject {
	String getName() {
		return "홍길동";
	}
}