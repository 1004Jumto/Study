package com.gorani.guestbook.service;

import com.gorani.guestbook.dto.GuestbookDTO;
import com.gorani.guestbook.dto.PageRequestDTO;
import com.gorani.guestbook.dto.PageResultDTO;
import com.gorani.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestbookServiceTests {
    @Autowired
    private GuestbookService guestbookService;

    @Test
    public void testRegister() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user0")
                .build();
        System.out.println(guestbookService.register(guestbookDTO));
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResultDTO<GuestbookDTO, Guestbook> resultDTO = guestbookService.getList(pageRequestDTO);

        for (GuestbookDTO guestbookDTO : resultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }

        System.out.println("prev: " + resultDTO.isPrev());
        System.out.println("next: " + resultDTO.isNext());
        System.out.println("total: " + resultDTO.getTotalPage());
        System.out.println("page: " + resultDTO.getPage());
        resultDTO.getPageList().forEach(System.out::println);
    }
}
