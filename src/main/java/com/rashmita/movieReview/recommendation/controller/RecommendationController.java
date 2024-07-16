//package com.rashmita.movieReview.recommendation.controller;
//
//import com.rashmita.movieReview.movie.entity.Movie;
//import com.rashmita.movieReview.recommendation.service.serviceImpl.RecommendationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/user")
//public class RecommendationController {
//
//    @Autowired
//    private RecommendationService recommendationService;
//
//    @GetMapping("/recomendation")
//    public List<Movie> getRecommendations(@RequestBody Long userId) {
//        return recommendationService.getRecommendations(userId);
//    }
//}
