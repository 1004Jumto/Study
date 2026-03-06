package com.gorani.mreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ReviewDTO {
    //review rno
    private Long reviewnum;

    //Movie mno
    private Long mno;

    //Memeber mid
    private Long mid;

    //Member nickname
    private String nickname;

    //Member email
    private String email;

    private int grade;

    private String text;

    private LocalDateTime regDate;
    private LocalDateTime modDate;


}
