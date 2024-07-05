package com.rashmita.movieReview.movie.model;

import com.rashmita.movieReview.movie.entity.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MovieDto {

    @NotBlank(message = "you must pass movie name")
    private String title;

    @NotBlank(message = "fill the genre of movie")
    private String genre;

    private String releaseDate;

    private String cast;

    private String crew;

    private String synopsis;

    private Status status;


}
