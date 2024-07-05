package com.rashmita.movieReview.rating.model;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

    private User userId;
    private Movie movieId;
    private int rating;
}
