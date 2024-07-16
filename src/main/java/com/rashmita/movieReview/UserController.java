package com.rashmita.movieReview;

import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.LoginResponse;
import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.LoginUserDto;
import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.RegisterUserDto;
import com.rashmita.movieReview.authentication.ImplementSecurity.services.AuthenticationService;
import com.rashmita.movieReview.authentication.ImplementSecurity.services.JwtService;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.model.*;
import com.rashmita.movieReview.movie.service.serviceImpl.MovieService;
import com.rashmita.movieReview.rating.model.RatingDto;
import com.rashmita.movieReview.rating.service.RatingService;
import com.rashmita.movieReview.recommendation.model.RecommendationDto;
import com.rashmita.movieReview.recommendation.service.serviceImpl.RecommendationService;
import com.rashmita.movieReview.review.model.ReviewDto;
import com.rashmita.movieReview.review.service.serviceImpl.ReviewService;
import com.rashmita.movieReview.user.entity.User;
import com.rashmita.movieReview.user.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private RecommendationService recommendationService;
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final ReviewService reviewService;
    private final RatingService ratingService;
    private final MovieService movieService;

    public UserController(JwtService jwtService, AuthenticationService authenticationService, ReviewService reviewService, RatingService ratingService, MovieService movieService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.reviewService = reviewService;
        this.ratingService = ratingService;
        this.movieService = movieService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String>  register(@RequestBody RegisterUserDto registerUserDto) throws Exception {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.status(HttpStatus.OK).body("signup successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<UserDto> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDto currentUser = (UserDto) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @PostMapping("/createReview")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> createReview(@RequestBody ReviewDto reviewDto) {

        reviewService.createReview(reviewDto);
        return ResponseEntity.status(HttpStatus.OK).body("Review created successfully.");
    }

    @PostMapping("/createRating")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> createRating(@RequestBody RatingDto ratingDto) {
        ratingService.createRating(ratingDto);
        return ResponseEntity.status(HttpStatus.OK).body("Rating created successfully.");
    }
    @GetMapping("/searchByTitle")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<Optional<Movie>> searchByTitle(@RequestBody MovieTitleRequest movieTitleRequest) {
        String title = movieTitleRequest.getTitle();
        Optional<Movie> movies = movieService.searchByTitle(title);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/searchByGenre")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<Movie>> searchByGenre(@RequestBody MovieGenreRequest movieGenreRequest) {
        String genre = movieGenreRequest.getGenre();
        List<Movie> movies = movieService.searchByGenre(genre);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/searchByReleaseDate")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<Movie>> searchByReleaseDate(@RequestBody MovieReleaseDateRequest movieReleaseDateRequest) {
        String releaseDate = movieReleaseDateRequest.getReleaseDate();
        List<Movie> movies = movieService.searchByReleaseDate(releaseDate);
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/searchByRating")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<MovieDto>> searchByRating(@RequestBody MovieRatingRequest movieRatingRequest) {
        int rating = movieRatingRequest.getRating();
        List<MovieDto> movies = ratingService.searchByRating(rating);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/getAllMovie")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<Movie>> getAllMovie() {
        List<Movie> movies=movieService.getAllMovie();
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<Movie>> searchMovies(@RequestBody MovieSearchCriteria criteria) {
        List<Movie> movies = movieService.searchMovies(criteria);
        return  ResponseEntity.ok(movies);
    }


    @GetMapping("/recomendation")
    @PreAuthorize("hasAnyRole('USER')")
    public List<Movie> getRecommendations(@RequestBody RecommendationDto recommendationDto) {
        return recommendationService.getRecommendations(recommendationDto);
    }

}
