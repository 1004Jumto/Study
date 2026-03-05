package com.gorani.mreview.repository;

import com.gorani.mreview.entity.Member;
import com.gorani.mreview.entity.Movie;
import com.gorani.mreview.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    // 회원이 작성한 리뷰 삭제
    @Modifying
    @Query("delete from Review mr where mr.member = :member")
    void deleteByMember(Member member);
}
