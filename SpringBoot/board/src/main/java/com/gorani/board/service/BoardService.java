package com.gorani.board.service;

import com.gorani.board.dto.BoardDTO;
import com.gorani.board.dto.PageRequestDTO;
import com.gorani.board.dto.PageResultDTO;
import com.gorani.board.entity.Board;
import com.gorani.board.entity.Member;

public interface BoardService {

    Long register(BoardDTO dto);

    BoardDTO get(Long bno);

    // 목록 처리
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO requestDTO);

    // 게시물 삭제
    void removeWithReplies(Long bno);

    // 게시물 수정
    void modify(BoardDTO dto);

    default Board dtoToEntity(BoardDTO dto) {

        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return board;
    }

    default BoardDTO entityToDto(Board board, Member member, Long replyCount) {
        BoardDTO dto = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())
                .build();

        return dto;
    }


}
