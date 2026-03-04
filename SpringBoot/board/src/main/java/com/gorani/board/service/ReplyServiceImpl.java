package com.gorani.board.service;

import com.gorani.board.dto.ReplyDTO;
import com.gorani.board.entity.Board;
import com.gorani.board.entity.Reply;
import com.gorani.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Override
    public Long register(ReplyDTO dto) {

        replyRepository.save(dtoToEntity(dto));

        return dto.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Long bno) {

        List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());

        return result.stream().map(this::entityToDto).collect(Collectors.toList());
    }


    @Override
    public void remove(Long rno) {

        replyRepository.deleteById(rno);
    }

    @Override
    public void modify(ReplyDTO dto) {

        Reply reply = dtoToEntity(dto);

        replyRepository.save(reply);
    }
}
