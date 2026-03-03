package com.gorani.guestbook.service;

import com.gorani.guestbook.dto.GuestbookDTO;
import com.gorani.guestbook.dto.PageRequestDTO;
import com.gorani.guestbook.dto.PageResultDTO;
import com.gorani.guestbook.entity.Guestbook;
import com.gorani.guestbook.entity.QGuestbook;
import com.gorani.guestbook.repository.GuestbookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository guestbookRepository;

    @Override
    public Long register(GuestbookDTO dto) {

        log.info("DTO------------------------");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);

        log.info(entity);

        guestbookRepository.save(entity);

        return entity.getGno();
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {

        // requestDTO에 있는 page, size로 pageable 생성
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        // + 검색 조건 추가
        BooleanBuilder builder = getSearch(requestDTO);

        // 조회: using pageable, bring guestbook list by function findAll
        Page<Guestbook> result = guestbookRepository.findAll(builder, pageable);

        // 결과로는 Guestbook 엔티티가 아니라 전달 형식인 ResultDTO로 변환해주기 위해 엔티티를 DTO로 변환하는 함수 등록
        Function<Guestbook, GuestbookDTO> fn = (this::entityToDto);

        // PageResultDTO 생성
        return new PageResultDTO<>(result, fn);

    }

    @Override
    public GuestbookDTO read(Long gno) {

        Optional<Guestbook> result = guestbookRepository.findById(gno);

        return result.map(this::entityToDto).orElse(null);
    }

    @Override
    public void modify(GuestbookDTO dto) {

        Optional<Guestbook> result = guestbookRepository.findById(dto.getGno());

        if (result.isPresent()) {
            Guestbook entity = result.get();
            entity.changeTitle(dto.getTitle());
            entity.changeContent(dto.getContent());

            guestbookRepository.save(entity);
        }
    }

    @Override
    public void remove(Long gno) {

        guestbookRepository.deleteById(gno);
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {

        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();

        BooleanBuilder builder = new BooleanBuilder();

        QGuestbook qGuestbook = QGuestbook.guestbook;

        // gno > 0 조건 생성 -> 인덱스를 타기 때문에 속도가 향상되므로 무조건 포함한다
        BooleanExpression expression = qGuestbook.gno.gt(0L);
        builder.and(expression);

        // 검색 조건이 없는 경우
        if (type == null || type.trim().length() == 0) {
            return builder;
        }

        // 검색 조건이 있는 경우
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(type.contains("t")) {
            conditionBuilder.or(qGuestbook.title.contains(keyword));
        }
        if(type.contains("c")) {
            conditionBuilder.or(qGuestbook.content.contains(keyword));
        }
        if(type.contains("w")) {
            conditionBuilder.or(qGuestbook.writer.contains(keyword));
        }

        // 모든 조건 통합
        builder.and(conditionBuilder);

        return builder;

    }
}
