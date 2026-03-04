package com.gorani.board.repository;

import com.gorani.board.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;
    /*
    * 자동 주입은 보통 스프링 컨테이너가 떠 있을때만 주입해줄 수 있음
    * @SpringBootTest를 붙이면 테스트 실행 시점에 스프링 부트 애플리케이션 컨텍스트(=스프링 컨테이너)가 실제로 올라온다
    * 운영처럼 “임시로” 한 번 띄워서(정확히는 테스트용 컨텍스트) 빈을 만들고 @Autowired도 그 컨텍스트에서 주입해준다
    * */

    @Test
    public void insertMembers() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder()
                    .email("user" + i + "@aaa.com")
                    .password("1111")
                    .name("USER" + i)
                    .build();

            memberRepository.save(member);
        });
    }

}
