package com.rashmita.movieReview.movie.model;

import com.rashmita.movieReview.movie.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MovieDto {

    private String title;

    private String genre;

    private String releaseDate;

    private String cast;

    private String director;

    private String producer;

    private String synopsis;

    private String picture;
//
//    private String Status;

}
