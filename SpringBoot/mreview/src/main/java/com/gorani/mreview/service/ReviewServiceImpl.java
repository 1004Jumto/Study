package com.gorani.mreview.service;

import com.gorani.mreview.dto.ReviewDTO;
import com.gorani.mreview.entity.Movie;
import com.gorani.mreview.entity.Review;
import com.gorani.mreview.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Long register(ReviewDTO reviewDTO) {
        log.info("movieReviewDTP: {}", reviewDTO);

        Review review = dtoToEntity(reviewDTO);
        reviewRepository.save(review);

        return review.getReviewnum();
    }

    @Override
    public void modify(ReviewDTO reviewDTO) {
        Optional<Review> result = reviewRepository.findById(reviewDTO.getReviewnum());

        if (result.isPresent()) {
            Review review = result.get();
            review.changeGrade(reviewDTO.getGrade());
            review.changeText(reviewDTO.getText());

            reviewRepository.save(review);
        }
    }

    @Override
    public void remove(Long reviewnum) {
        reviewRepository.deleteById(reviewnum);
    }

    @Override
    public ReviewDTO getReview(Long reviewnum) {
        return null;
    }

    @Override
    public List<ReviewDTO> getListOfMovie(Long mno) {
        Movie movie = Movie.builder().mno(mno).build();
        List<Review> reviewList = reviewRepository.findByMovie(movie);

        return reviewList.stream().map(this::entityToDTO).toList();
    }
}
