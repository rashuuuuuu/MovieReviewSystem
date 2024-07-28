package com.rashmita.movieReview.movie.model;

import com.rashmita.movieReview.movie.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieIdRequest {
    private Long movieId;
}
