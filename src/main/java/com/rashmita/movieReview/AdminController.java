package com.rashmita.movieReview;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.model.*;
import com.rashmita.movieReview.movie.service.serviceImpl.MovieService;
import com.rashmita.movieReview.rating.service.RatingService;
import com.rashmita.movieReview.review.model.ReviewContent;
import com.rashmita.movieReview.review.service.serviceImpl.ReviewService;
import com.rashmita.movieReview.user.model.UserDto;
import com.rashmita.movieReview.user.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final MovieService movieService;
    private final RatingService ratingService;
    private final UserService userService;
    private final ReviewService reviewService;


    @PostMapping("/createMovie")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> createMovie(@RequestBody MovieDto movieDto) {
        movieService.createMovie(movieDto);
        return ResponseEntity.status(HttpStatus.OK).body("Movie created successfully.");
    }

    @PostMapping("/updateMovie")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> updateMovie(@RequestBody MovieDto movieDto) {
        movieService.updateMovie(movieDto);
        return ResponseEntity.status(HttpStatus.OK).body("Movie updated successfully.");
    }

    @PostMapping("/deleteMovie")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> deleteMovie(@RequestBody MovieTitleRequest movieTitleRequest) {
        movieService.deleteMovie(movieTitleRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully.");
    }

//    @GetMapping("/searchByTitle")
//    public ResponseEntity<Optional<Movie>> searchByTitle(@RequestBody MovieTitleRequest movieTitleRequest) {
//        String title = movieTitleRequest.getTitle();
//        Optional<Movie> movies = movieService.searchByTitle(title);
//        return ResponseEntity.ok(movies);
//    }

//    @GetMapping("/searchByGenre")
//    public ResponseEntity<List<Movie>> searchByGenre(@RequestBody MovieGenreRequest movieGenreRequest) {
//        String genre = movieGenreRequest.getGenre();
//        List<Movie> movies = movieService.searchByGenre(genre);
//        return ResponseEntity.ok(movies);
//    }
//
//    @GetMapping("/searchByReleaseDate")
//    public ResponseEntity<List<Movie>> searchByReleaseDate(@RequestBody MovieReleaseDateRequest movieReleaseDateRequest) {
//        String releaseDate = movieReleaseDateRequest.getReleaseDate();
//        List<Movie> movies = movieService.searchByReleaseDate(releaseDate);
//        return ResponseEntity.ok(movies);
//    }
//
//
//    @GetMapping("/searchByRating")
//    public ResponseEntity<List<Movie>> searchByRating(@RequestBody MovieRatingRequest movieRatingRequest) {
//        int rating = movieRatingRequest.getRating();
//        List<Movie> movies = ratingService.searchByRating(rating);
//        return ResponseEntity.ok(movies);
//    }

    @GetMapping("/getAllMovie")
    public ResponseEntity<List<MovieDto>> getAllMovie() {
        return ResponseEntity.ok(movieService.getAllMovie());
    }

//
//    @GetMapping("/search")
//    public ResponseEntity<List<Movie>> searchMovies(@RequestBody MovieSearchCriteria criteria) {
//        List<Movie> movies = movieService.searchMovies(criteria);
//        return new ResponseEntity<>(movies, HttpStatus.OK);
//    }

    @GetMapping("/getAllUser")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List<UserDto>> allUsers() {
        List<UserDto> users = userService.allUsers();

        return ResponseEntity.ok(users);

    }
    @PostMapping("/averageRating")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> getAverageRating(@RequestBody MovieIdRequest movieIdRequest) {
        Double rating = ratingService.getAveragerating(movieIdRequest);
        return ResponseEntity.status(HttpStatus.OK).body("average rating=" + rating);
    }
    @GetMapping("/noOfReview")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> noOfReview() {
        int count=reviewService.noOfReview();
        return ResponseEntity.status(HttpStatus.OK).body("No Of Review="+count);
    }

    @PostMapping("/deleteReview")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> deleteContent(@RequestBody ReviewContent reviewContent) {
        reviewService.deleteContent(reviewContent);
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully.");
    }
}


