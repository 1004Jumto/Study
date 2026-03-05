package com.gorani.mreview.repository;

import com.gorani.mreview.entity.Member;
import com.gorani.mreview.entity.Movie;
import com.gorani.mreview.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMovieReviews() {

        IntStream.rangeClosed(1, 200).forEach(i -> {

            //영화 번호
            Long mno = (long) (Math.random() * 100) + 1;

            //리뷰어 번호
            Long mid = ((long) (Math.random() * 100) + 1);
            int grade = (int) (Math.random() * 5) + 1;
            Member member = Member.builder().mid(mid).build();

            Review review = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade(grade)
                    .text("이 영화에 대한 느낌..." + i)
                    .build();

            reviewRepository.save(review);
        });

    }

    @Test
    public void testGetMovieReviews() {
        Movie movie = Movie.builder().mno(97L).build();
        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(movieReview -> {
            System.out.println(movieReview.getReviewnum());
            System.out.println("\t" + movieReview.getGrade());
            System.out.println("\t" + movieReview.getText());
            System.out.println("\t" + movieReview.getMember().getEmail());
        });
    }

    @Test
    @Transactional
    @Commit
    public void testDeleteMember() {
        Long mid = 2L;
        Member member = Member.builder().mid(mid).build();

        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);
    }
}
