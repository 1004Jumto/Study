package kr.co.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Mockito 테스트")
@ExtendWith(MockitoExtension.class)
public class SampleTest6 {
	@Mock
	SampleObject1 mockObject;

	@Spy
	SampleObject2 spyObject;

	@InjectMocks
	SampleService service;

	@Test
	@DisplayName("@InjectMocks를 사용한 게시판 목록 조회 테스트")
	public void spyTest() {
		System.out.println(service.getName1()); // null
		System.out.println(service.getName2()); // 김길동
	}

}

class SampleObject1 {
	String getName() {
		return "홍길동";
	}
}

class SampleObject2 {
	String getName() {
		return "김길동";
	}
}

class SampleService {
	SampleObject1 so1;
	SampleObject2 so2;

	SampleService(SampleObject1 so1, SampleObject2 so2) {
		this.so1 = so1;
		this.so2 = so2;
	}

	String getName1() {
		return so1.getName();
	}

	String getName2() {
		return so2.getName();
	}
}