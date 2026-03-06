package com.gorani.mreview.service;

import com.gorani.mreview.dto.MovieDTO;
import com.gorani.mreview.dto.MovieImageDTO;
import com.gorani.mreview.dto.PageRequestDTO;
import com.gorani.mreview.dto.PageResultDTO;
import com.gorani.mreview.entity.Movie;
import com.gorani.mreview.entity.MovieImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface MovieService {

    Long register(MovieDTO movieDTO);

    // 목록 처리
    PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO requestDTO);

    // 영화 조회
    MovieDTO getMovie(Long mno);

    default MovieDTO entitiesToDTO(Movie movie, List<MovieImage> movieImages, Double avg, Long reviewCnt){
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movie.getMno())
                .title(movie.getTitle())
                .regDate(movie.getRegDate())
                .modDate(movie.getModDate())
                .build();

        List<MovieImageDTO> movieImageDTOList = movieImages.stream().map(movieImage -> {
            return MovieImageDTO.builder().imgName(movieImage.getImgName())
                    .path(movieImage.getPath())
                    .uuid(movieImage.getUuid())
                    .build();

        }).toList();

        movieDTO.setImageDTOList(movieImageDTOList);
        movieDTO.setAvg(avg);
        movieDTO.setReviewCnt(reviewCnt.intValue());

        return movieDTO;
    }

    default Map<String, Object> dtoToEntity(MovieDTO movieDTO) {

        Map<String, Object> entityMap = new HashMap<>();

        Movie movie = Movie.builder()
                .mno(movieDTO.getMno())
                .title(movieDTO.getTitle())
                .build();

        entityMap.put("movie", movie);

        List<MovieImageDTO> imageDTOList = movieDTO.getImageDTOList();
        if (imageDTOList != null && !imageDTOList.isEmpty()) {
            List<MovieImage> movieImageList = imageDTOList.stream().map(movieImageDTO -> {
                return MovieImage.builder()
                        .uuid(movieImageDTO.getUuid())
                        .imgName(movieImageDTO.getImgName())
                        .path(movieImageDTO.getPath())
                        .movie(movie)
                        .build();

            }).collect(Collectors.toList());

            entityMap.put("imageList", movieImageList);
        }

        return entityMap;
    }

}
