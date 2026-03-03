package com.gorani.guestbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // 감사 기능
@SpringBootApplication
public class GuestbookApplication {
    /*
    * Application Context를 생성: 스프링이 관리할 객체(bean)들을 담는 IOC 컨테이너 생성
    * @SpringBootApplication을 기준으로 스캔 시작점 결정
    * @EnableJpaAuditing 은 JPA의 감사기능을 켜는 스위치로,
    * 엔티티에 누가/언제 만들었고, 언제 수정됐는지를 저장하는 값을 자동으로 채워주는 기능
    *
    * */
    public static void main(String[] args) {
        SpringApplication.run(GuestbookApplication.class, args);
    }

}
