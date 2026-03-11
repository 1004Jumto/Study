package com.gorani.mreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@SpringBootApplication
public class MreviewApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(MreviewApplication.class, args);
    }

//    /*
//    * WebMvcConfigurer: 스프링 MVC의 동작 방식을 “내가 원하는 대로 조금씩 커스터마이징” 할 때 쓰는 설정용 인터페이스
//    * */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/member/login").setViewName("forward:/member/login");
//    }

}
