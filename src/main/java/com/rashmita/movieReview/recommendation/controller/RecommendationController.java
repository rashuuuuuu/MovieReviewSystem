package com.rashmita.movieReview.recommendation.controller;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.model.MovieRatingRequest;
import com.rashmita.movieReview.recommendation.model.RecommendationDto;
import com.rashmita.movieReview.recommendation.service.serviceImpl.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class RecommendationController {
//@Autowired
//private RecommendationService recommendationService;
//@GetMapping("/recommendation")
//public ResponseEntity<List<Movie>> recommendMovies(@RequestBody RecommendationDto recommendationDto) {
//    List<Movie> movies =recommendationService.recommendMovies(recommendationDto);
//    return ResponseEntity.ok(movies);
//}

}
