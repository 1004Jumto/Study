package com.gorani.board.service;

import com.gorani.board.dto.BoardDTO;
import com.gorani.board.dto.PageRequestDTO;
import com.gorani.board.dto.PageResultDTO;
import com.gorani.board.entity.Board;
import com.gorani.board.entity.Member;
import com.gorani.board.repository.BoardRepository;
import com.gorani.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    @Override
    public Long register(BoardDTO dto) {

        log.info(dto);

        boardRepository.save(dtoToEntity(dto));

        return dto.getBno();
    }

    @Override
    public BoardDTO get(Long bno) {

        Object result = boardRepository.getBoardByBno(bno);
        Object[] arr = (Object[]) result;

        return entityToDto((Board) arr[0], (Member) arr[1], (Long) arr[2]);
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO requestDTO) {

        log.info(requestDTO);

        Function<Object[], BoardDTO> fn = (en -> entityToDto((Board) en[0], (Member) en[1], (Long) en[2]));

//        Page<Object[]> result = boardRepository.getBoardWithReplyCount(requestDTO.getPageable(Sort.by("bno").descending()));

        Page<Object[]> result = boardRepository.searchPage(
                requestDTO.getType(),
                requestDTO.getKeyword(),
                requestDTO.getPageable(Sort.by("bno").descending())
        );
        log.info(result);

        return new PageResultDTO<>(result, fn);

    }

    @Override
    @Transactional
    public void removeWithReplies(Long bno) {

        // 댓글 먼저 삭제
        replyRepository.deleteByBno(bno);
        // 게시글 삭제
        boardRepository.deleteById(bno);
    }

    @Override
    @Transactional
    public void modify(BoardDTO dto) {

        Board board = boardRepository.getReferenceById(dto.getBno());

        if(board != null) {

            board.changeTitle(dto.getTitle());
            board.changeContent(dto.getContent());

            boardRepository.save(board);
        }
    }
}
