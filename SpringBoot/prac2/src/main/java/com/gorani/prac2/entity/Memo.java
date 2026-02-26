package com.gorani.prac2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity                     // 엔티티 클래스임을 선언
@Table(name = "tbl_memo")   // 테이블 이름 설정
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @Id    // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 키 생성 전략
    public Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;
}
