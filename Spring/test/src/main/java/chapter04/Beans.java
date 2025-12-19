package chapter04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "chapter04")
public class Beans {

	// 원래 했던 DI 방식
//	@Bean
//	public BoardDAO boarDao() {
//		return new BoardDAO();
//	}
	
}
