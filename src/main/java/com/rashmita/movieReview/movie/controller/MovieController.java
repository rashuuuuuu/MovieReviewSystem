package com.rashmita.movieReview.movie.controller;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.model.*;
import com.rashmita.movieReview.movie.service.serviceImpl.MovieService;
import com.rashmita.movieReview.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final RatingService ratingService;


    @PostMapping("/createMovie")
    public ResponseEntity<String> createMovie(@RequestBody MovieDto movieDto) {
         movieService.createMovie(movieDto);
        return ResponseEntity.status(HttpStatus.OK).body("Movie created successfully.");
    }
    @PostMapping("/updateMovie")
    public ResponseEntity<String> updateMovie(@RequestBody MovieDto movieDto) {
        movieService.updateMovie(movieDto);
        return ResponseEntity.status(HttpStatus.OK).body("Movie updated successfully.");
    }

    @PostMapping("/deleteMovie")
    public ResponseEntity<String> deleteMovie(@RequestBody MovieTitleRequest movieTitleRequest) {
        movieService.deleteMovie(movieTitleRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully.");
    }

    @GetMapping("/searchByTitle")
    public ResponseEntity<List<Movie>> searchByTitle(@RequestBody MovieTitleRequest movieTitleRequest) {
        String title = movieTitleRequest.getTitle();
        List<Movie> movies = movieService.searchByTitle(title);
        return ResponseEntity.ok(movies);
}
    @GetMapping("/searchByGenre")
    public ResponseEntity<List<Movie>> searchByGenre(@RequestBody MovieGenreRequest movieGenreRequest){
        String genre = movieGenreRequest.getGenre();
        List<Movie> movies = movieService.searchByGenre(genre);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/searchByReleaseDate")
    public ResponseEntity<List<Movie>> searchByReleaseDate(@RequestBody MovieReleaseDateRequest movieReleaseDateRequest) {
        String releaseDate = movieReleaseDateRequest.getReleaseDate();
        List<Movie> movies = movieService.searchByReleaseDate(releaseDate);
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/searchByRating")
    public ResponseEntity<List<Movie>> searchByRating(@RequestBody MovieRatingRequest movieRatingRequest) {
        int rating = movieRatingRequest.getRating();
        List<Movie> movies = ratingService.searchByRating(rating);
        return ResponseEntity.ok(movies);
    }
}
