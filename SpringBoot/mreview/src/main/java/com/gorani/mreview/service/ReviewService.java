package com.gorani.mreview.service;

import com.gorani.mreview.dto.ReviewDTO;
import com.gorani.mreview.entity.Member;
import com.gorani.mreview.entity.Movie;
import com.gorani.mreview.entity.Review;

import java.util.List;

public interface ReviewService {

    // 리뷰 등록
    Long register(ReviewDTO movieReviewDTP);

    // 리뷰 수정
    void modify(ReviewDTO reviewDTO);

    // 리뷰 삭제
    void remove(Long reviewnum);

    // 리뷰 조회
    ReviewDTO getReview(Long reviewnum);

    // 영화의 모든 리뷰 조회
    List<ReviewDTO> getListOfMovie(Long mno);

    default ReviewDTO entityToDTO(Review review) {
        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewnum(review.getReviewnum())
                .mno(review.getMovie().getMno())
                .mid(review.getMember().getMid())
                .nickname(review.getMember().getNickname())
                .email(review.getMember().getEmail())
                .grade(review.getGrade())
                .text(review.getText())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .build();

        return reviewDTO;
    }

    default Review dtoToEntity(ReviewDTO reviewDTO) {
        Review review = Review.builder()
                .reviewnum(reviewDTO.getReviewnum())
                .movie(Movie.builder().mno(reviewDTO.getMno()).build())
                .member(Member.builder().mid(reviewDTO.getMid()).build())
                .grade(reviewDTO.getGrade())
                .text(reviewDTO.getText())
                .build();

        return review;
    }

}
