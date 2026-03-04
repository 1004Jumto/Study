package com.gorani.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "writer")   // Lombok의 toString() 자동생성에서 특정 필드(writer)를 출력에서 제외
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;
    private String content;

    // 이 필드는 FK로 연결된 관계임을 인식
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

}

/*
* ToString exclude 하는 이유
* - JPA 연관관계 양방향에서 주로 사용하는데,
* - toString이 서로를 계속 호출해서 무한 루프에 빠져 StackOverFlow 발생 위험이 있다
* - 예시로, Guestbook.toString()이 writer.toString() 호출
* - writer.toString()이 다시 guestbooks.toString() 호출
* - … 무한 반복
* 따라서, 연관관계 필드에는 ToString을 신중히 쓰거나 exclude로 제외한다
* 추가로, @Data는 toString, equals/hashCode까지 다 자동 생성하기 때문에 더 에러가 발생할 위험이 크므로 Data 사용 지양
*
* @ManyToOne
* Hibernate는 해당 필드를 보고 Board 테이블에 Member FK 컬럼이 있고, 연결된다
*
* EAGER Loading
* - 보통은 EAGER 인데, eager loading 이란, 특정한 엔티티를 조회할 때 연관관계를 가진 모든 엔티티를 같이 로딩하는 것
* - "즉시 로딩"이라고도 하며, 한 번에 연관관계가 있는 모든 엔티티를 가져오지만, 연관관계가 복잡할수록 조인으로 인한 성능 저하는 불가피하다
*
* fetch
* - JPA에서 데이터를 어떻게 가져올 것인가
* - 어노테이션으로 모드 지정 가능
*
* LAZY LOADING
* - 즉시로딩은 불필요한 조인까지 처리해야하는 경우가 많아 대부분 Lazy loading으로 처리한다
* - "지연 로딩" 이라고도 하며, 조인하지 않고 실제 데이터가 필요할 때 쿼리를 실행해 가져온다
* */