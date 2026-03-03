package com.gorani.board.repository;

import com.gorani.board.entity.Member;
import com.gorani.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
