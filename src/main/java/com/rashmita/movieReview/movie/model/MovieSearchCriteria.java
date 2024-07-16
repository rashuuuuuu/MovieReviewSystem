package com.rashmita.movieReview.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MovieSearchCriteria {
    private String genre;
    private String title;
    private String releaseDate;
}
