package com.gorani.mreview.service;

import com.gorani.mreview.dto.MovieDTO;
import com.gorani.mreview.entity.Movie;
import com.gorani.mreview.entity.MovieImage;
import com.gorani.mreview.repository.MovieImageRepository;
import com.gorani.mreview.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieImageRepository movieImageRepository;

    @Override
    @Transactional
    public Long register(MovieDTO movieDTO) {
        log.info("movieDTO: {}", movieDTO);

        Map<String, Object> entityMap = dtoToEntity(movieDTO);
        Movie movie = (Movie) entityMap.get("movie");
        List<MovieImage> movieImageList = (List<MovieImage>) entityMap.get("imageList");

        movieRepository.save(movie);
        movieImageRepository.saveAll(movieImageList);

        return movie.getMno();
    }

}
