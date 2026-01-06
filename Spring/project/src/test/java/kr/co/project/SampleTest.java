package kr.co.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SampleTest {
	
	// 모든 테스트 전 실행
	@BeforeAll
	static void beforeAll() {
		System.out.println("BeforeAll");
	}
	
	// 각 테스트 전 실행
	@BeforeEach
	void beforeEach() {
		System.out.println("BeforeEach");
	}
	
	// 각 테스트 후 실행
	@AfterEach
	void afterEach() {
		System.out.println("AfterEach");
	}
	
	@Test
	void test() {
		System.out.println("test");
	}
}
