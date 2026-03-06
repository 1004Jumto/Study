package com.gorani.mreview.controller;

import com.gorani.mreview.dto.ReviewDTO;
import com.gorani.mreview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{mno}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable Long mno) {
        log.info("mno: {}", mno);

        List<ReviewDTO> reviewDTOList = reviewService.getListOfMovie(mno);

        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    @PostMapping("/{mno}")
    public ResponseEntity<Long> addReview(@PathVariable Long mno, @RequestBody ReviewDTO reviewDTO) {
        log.info("mno: {}, reviewDTO: {}", mno, reviewDTO);

//        reviewDTO.setMno(mno);
        Long reviewnum = reviewService.register(reviewDTO);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }

    @PutMapping("/{mno}/{reviewnum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long mno, @PathVariable Long reviewnum, @RequestBody ReviewDTO reviewDTO) {
        log.info("mno: {}, reviewnum: {}, reviewDTO: {}", mno, reviewnum, reviewDTO);

//        reviewDTO.setMno(mno);
//        reviewDTO.setReviewnum(reviewnum);
        reviewService.modify(reviewDTO);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }

    @DeleteMapping("/{mno}/{reviewnum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long mno, @PathVariable Long reviewnum) {
        log.info("mno: {}, reviewnum: {}", mno, reviewnum);

        reviewService.remove(reviewnum);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }
}
