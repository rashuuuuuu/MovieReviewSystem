package com.rashmita.movieReview.rating.controller;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.rating.model.RatingDto;
import com.rashmita.movieReview.rating.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/movie")
@RestController
@AllArgsConstructor
public class RatingController {
    @Autowired
    private final RatingService ratingService;

    @PostMapping("/createRating")
    public ResponseEntity<String> createRating(@RequestBody RatingDto ratingDto) {
        ratingService.createRating(ratingDto);
        return ResponseEntity.status(HttpStatus.OK).body("Rating created successfully.");
    }


    @GetMapping("/averageRating")
    public ResponseEntity<String> getAverageRating(@RequestBody Movie movieId) {
        Double rating = ratingService.getAveragerating(movieId);
        return ResponseEntity.status(HttpStatus.OK).body("average rating=" + rating);
    }
}