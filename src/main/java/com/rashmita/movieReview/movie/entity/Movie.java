package com.rashmita.movieReview.movie.entity;

import com.rashmita.movieReview.rating.entity.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="genre")
    private String genre;

    @Column(name="releaseDate")
    private String releaseDate;

    @Column(name="cast")
    private String cast;

    @Column(name="director")
    private String director;

    @Column(name="producer")
    private String producer;

    @Column(name="synopsis")
    private String synopsis;

    @Column(name = "picture")
    private String picture;

    @Column(name="view_count")
    private Integer viewCount;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
