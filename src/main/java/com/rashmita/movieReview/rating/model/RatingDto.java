package com.rashmita.movieReview.rating.model;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.model.MovieIdRequest;
import com.rashmita.movieReview.user.entity.User;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

    private MovieIdRequest movieIdRequest;
    @Min(1)
    @Max(5)
    private int rating;
}
