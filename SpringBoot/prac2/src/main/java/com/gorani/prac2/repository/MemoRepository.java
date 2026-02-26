package com.gorani.prac2.repository;

import com.gorani.prac2.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    // 쿼리 메소드
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    // 페이징 처리 + 정렬
    Page<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);

    void deleteMemoByMnoLessThan(Long num);
}
