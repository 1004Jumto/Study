package com.gorani.board.service;

import com.gorani.board.dto.ReplyDTO;
import com.gorani.board.entity.Board;
import com.gorani.board.entity.Reply;

import java.util.List;

public interface ReplyService {
    Long register(ReplyDTO dto);

    List<ReplyDTO> getList(Long rno);

    void remove(Long rno);

    void modify(ReplyDTO dto);

    default Reply dtoToEntity(ReplyDTO replyDTO) {

        Board board = Board.builder().bno(replyDTO.getBno()).build();

        Reply reply = Reply.builder()
                .rno(replyDTO.getRno())
                .text(replyDTO.getText())
                .replyer(replyDTO.getReplyer())
                .board(board)
                .build();

        return reply;
    }

    default ReplyDTO entityToDto(Reply reply) {

        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
//                .bno(reply.getBoard().getBno())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();

        return replyDTO;
    }
}
