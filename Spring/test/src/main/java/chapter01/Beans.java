package chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정파일
public class Beans {

    //빈 등록
    @Bean
    public Person person() { //person - 메서드이름(id) 

        return new Person();
    }
    
    @Bean
    public Person person2() {
    	return new Person("김길동", 30);
    }

}