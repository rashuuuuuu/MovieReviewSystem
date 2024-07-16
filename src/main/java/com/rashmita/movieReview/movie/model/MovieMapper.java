package com.rashmita.movieReview.movie.model;
import com.rashmita.movieReview.movie.entity.Movie;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    @Mapping(source = "status", target = "status")
    MovieDto toDto(Movie movie);

}