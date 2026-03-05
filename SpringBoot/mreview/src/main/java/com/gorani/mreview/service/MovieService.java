package com.gorani.mreview.service;

import com.gorani.mreview.dto.MovieDTO;
import com.gorani.mreview.dto.MovieImageDTO;
import com.gorani.mreview.entity.Movie;
import com.gorani.mreview.entity.MovieImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface MovieService {

    Long register(MovieDTO movieDTO);

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
