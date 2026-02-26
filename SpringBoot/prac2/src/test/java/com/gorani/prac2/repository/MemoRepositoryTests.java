package com.gorani.prac2.repository;

import com.gorani.prac2.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());        // jdk.proxy3.$Proxy147

        Memo memo = new Memo();
        System.out.println(memo.getClass().getName());                  // 순수 객체이므로 com.gorani.prac2.entity.Memo
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    @Transactional      // @Test인 경우 @Transactional을 붙여야 롤백되어 실제 db에 저장 안됨
    public void testInsertDummies2() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i * 1000).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect() {
        Long mno = 100L;
        Optional<Memo> result = memoRepository.findById(mno);

        result.ifPresent(System.out::println);

//        if(result.isPresent()) {
//            Memo memo = result.get();
//            System.out.println(memo);
//        }
    }

    @Test
    public void testSelect2() {         // SQL의 실행 시점이 다름 -> lazy 로딩
        Long mno = 100L;
        Memo result = memoRepository.getOne(mno);

        System.out.println("============================");
        System.out.println(result);
    }

    @Test
    public void testUpdate() {
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println(memoRepository.save(memo));
    }

    @Test
    public void testDelete() {
        Long mno = 99L;
        memoRepository.deleteById(mno);
    }

    @Test
    public void testPageDefault() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println(result);

        System.out.println("----------------------");
        System.out.println(result.getTotalPages());
        System.out.println(result.getTotalElements());
        System.out.println(result.getNumber());
        System.out.println(result.getSize());
        System.out.println(result.hasNext());
        System.out.println(result.isFirst());

        for (Memo memo : result.getContent()) {
            System.out.println(memo);
        }

        result.get().forEach(System.out::println);
    }

    @Test
    public void testQueryMethodWithPageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
        result.forEach(System.out::println);
    }

    @Test
    @Commit
    @Transactional
    public void testDeleteQueryMethods() {
        memoRepository.deleteMemoByMnoLessThan(10L);
    }
}
