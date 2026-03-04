package com.gorani.board.service;

import com.gorani.board.dto.BoardDTO;
import com.gorani.board.dto.PageRequestDTO;
import com.gorani.board.dto.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {

        BoardDTO dto = BoardDTO.builder()
                .title("Test.")
                .content("Test...")
                .writerEmail("user55@aaa.com") // DB에 존재하는 이메일
                .build();

        Long bno = boardService.register(dto);

    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : result.getDtoList()) {
            System.out.println(boardDTO);
        }

    }

    @Test
    public void testGet() {

        Long bno = 100L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);

    }

    @Test
    public void testRemove() {

        Long bno = 2L;
        boardService.removeWithReplies(bno);

    }

    @Test
    public void testModify() {

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(1L)
                .title("변경된 제목")
                .content("변경된 내용")
                .build();

        boardService.modify(boardDTO);

    }
}
