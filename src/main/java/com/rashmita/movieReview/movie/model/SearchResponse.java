package com.rashmita.movieReview.movie.model;

import com.rashmita.movieReview.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse implements Serializable {
    private String title;
    private String genre;
    private String synopsis;
    private String releaseDate;
    private String cast;
    private String crew;
}
