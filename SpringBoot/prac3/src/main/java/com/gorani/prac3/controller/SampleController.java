package com.gorani.prac3.controller;

import com.gorani.prac3.dto.SampleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Slf4j
public class SampleController {

    @GetMapping("/ex1")
    public void ex1() {
        log.info("ex1..........");
    }

    @GetMapping("/ex2")
    public void ex2(Model model) {
        log.info("ex2..........");

        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder().sno(i).first("first..." + i).last("last..." + i).regTime(LocalDateTime.now()).build();
            return dto;
        }).collect(Collectors.toList());

        model.addAttribute("list", list);
    }

    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes) {
        log.info("exInline..........");

        SampleDTO dto = SampleDTO.builder().sno(100L).first("first..." + 100L).last("last..." + 100L).regTime(LocalDateTime.now()).build();
        redirectAttributes.addFlashAttribute("dto", dto);
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/sample/ex3";
    }

    @GetMapping("/ex3")
    public void ex3(){
        log.info("ex3..........");
    }
}
