package com.gorani.mreview.repository;

import com.gorani.mreview.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
