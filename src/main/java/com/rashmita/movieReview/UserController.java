package com.rashmita.movieReview;

import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.LoginResponse;
import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.LoginUserDto;
import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.RegisterUserDto;
import com.rashmita.movieReview.authentication.ImplementSecurity.services.AuthenticationService;
import com.rashmita.movieReview.authentication.ImplementSecurity.services.JwtService;
import com.rashmita.movieReview.emailValidation.EmailValidationService;
import com.rashmita.movieReview.movie.model.*;
import com.rashmita.movieReview.movie.service.serviceImpl.MovieService;
import com.rashmita.movieReview.rating.model.RatingDto;
import com.rashmita.movieReview.rating.service.RatingService;
import com.rashmita.movieReview.recommendation.service.serviceImpl.RecommendationService;
import com.rashmita.movieReview.review.model.ReviewDto;
import com.rashmita.movieReview.review.service.serviceImpl.ReviewService;
import com.rashmita.movieReview.user.entity.User;
import com.rashmita.movieReview.user.model.ProfileDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RecommendationService recommendationService;
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final ReviewService reviewService;
    private final RatingService ratingService;
    private final MovieService movieService;
    private final EmailValidationService emailValidationService;

    public UserController(JwtService jwtService, AuthenticationService authenticationService, ReviewService reviewService, RatingService ratingService, MovieService movieService, EmailValidationService emailValidationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.reviewService = reviewService;
        this.ratingService = ratingService;
        this.movieService = movieService;
        this.emailValidationService = emailValidationService;

    }

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody RegisterUserDto registerUserDto) throws Exception {
        String registeredUser = authenticationService.signup(registerUserDto);
        String email = registerUserDto.getEmail();
        return new ResponseEntity<>(emailValidationService.sendEmailWithoutBody(email), HttpStatus.OK);

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

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('USER')")
    public ProfileDto authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return modelMapper.map(currentUser, ProfileDto.class);
//        return ResponseEntity.ok(savedUserDto);
//        return UserMapper.mapToUserDto(user);


    }

    @PostMapping("/createReview")
    @PreAuthorize("hasAnyRole('USER')")
    @Operation(
            security = @SecurityRequirement(name = "movieReview")
    )
    public ResponseEntity<String> createReview(@RequestBody ReviewDto reviewDto) {

        reviewService.createReview(reviewDto);
        return ResponseEntity.status(HttpStatus.OK).body("Review created successfully.");
    }

    @PostMapping("/createRating")
    @PreAuthorize("hasAnyRole('USER')")
    @Operation(
            security = @SecurityRequirement(name = "movieReview")
    )
    public ResponseEntity<String> createRating(@RequestBody RatingDto ratingDto) {
        ratingService.createRating(ratingDto);
        return ResponseEntity.status(HttpStatus.OK).body("Rating created successfully.");
    }

    @PostMapping("/searchByTitle")
    public ResponseEntity<List<MovieDto>> searchByTitle(@RequestBody MovieTitleRequest movieTitleRequest) {
        String title = movieTitleRequest.getTitle();
        List<MovieDto> movies = movieService.searchByTitle(title);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/getById")
    public ResponseEntity<List<MovieDto>> getDetailsById(@RequestBody MovieIdRequest movieIdRequest) {
        Long id = movieIdRequest.getMovieId();
        List<MovieDto> movies = movieService.getDetailsById(id);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/searchByGenre")
    public ResponseEntity<List<MovieDto>> searchByGenre(@RequestBody MovieGenreRequest movieGenreRequest) {
        String genre = movieGenreRequest.getGenre();
        List<MovieDto> movies = movieService.searchByGenre(genre);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/searchByReleaseDate")

    public ResponseEntity<List<MovieDto>> searchByReleaseDate(@RequestBody MovieReleaseDateRequest movieReleaseDateRequest) {
        String releaseDate = movieReleaseDateRequest.getReleaseDate();
        List<MovieDto> movies = movieService.searchByReleaseDate(releaseDate);
        return ResponseEntity.ok(movies);
    }


    @PostMapping("/searchByRating")

    public ResponseEntity<List<MovieDto>> searchByRating(@RequestBody MovieRatingRequest movieRatingRequest) {
        MovieRatingRequest rating = movieRatingRequest;
        List<MovieDto> movies = ratingService.searchByRating(rating);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/getAllMovie")

    public ResponseEntity<List<MovieDto>> getAllMovie() {
        List<MovieDto> movies = movieService.getAllMovie();
        return ResponseEntity.ok(movies);
    }


    @PostMapping("/search")
    public ResponseEntity<List<MovieDto>> searchMovies(@RequestBody MovieSearchCriteria criteria) {
        List<MovieDto> movies = movieService.searchMovies(criteria);
        return ResponseEntity.ok(movies);
    }


    @GetMapping("/recomendation")
    public List<MovieDto> getRecommendations() {
        return recommendationService.getRecommendations();
    }


    @GetMapping("/trending")
    public List<MovieDto> trending() {
        return movieService.trending();
    }
}


