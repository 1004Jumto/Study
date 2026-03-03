package com.gorani.board.repository;

import com.gorani.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // JPQL
    // “Board 엔티티를 기준으로 writer 연관을 LEFT JOIN 해서 같이 조회하겠다"
    // :bno 는 named param으로 메소드에 파라미터로 받아서 바인딩
    // Borad와 writer는 테이블을 뜻하는 것이 아니라 엔티티를 의미
    @Query("select b, w from Board b left join b.writer w where b.bno = :bno")
    Object getBoardWithWriter(@Param("bno") Long bno);

    @Query("select b, r from Board b left join Reply r on r.board = b where b.bno = :bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    @Query(value = "select b, w, count(r) " +
            " from Board b " +
            " left join b.writer w " +
            " left join Reply r ON r.board = b " +
            " group by b",
            countQuery = "select count(b) from Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);

}
