package com.rashmita.movieReview.review.model;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.user.entity.User;
import com.rashmita.movieReview.user.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Movie movie;

    private String content;

    private Double rating;

    private Timestamp timestamp;

}
