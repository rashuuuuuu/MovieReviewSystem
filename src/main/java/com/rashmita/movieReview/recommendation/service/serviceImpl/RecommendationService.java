package com.rashmita.movieReview.recommendation.service.serviceImpl;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.repo.MovieRepository;
import com.rashmita.movieReview.rating.entity.Rating;

import com.rashmita.movieReview.rating.repo.RatingRepository;

import com.rashmita.movieReview.recommendation.model.RecommendationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RecommendationService {
//    @Autowired
//    private RatingRepository ratingRepository;
//    @Autowired
//    private MovieRepository movieRepository;
//
//    private int getHighRating(RecommendationDto recommendationDto){
//        return ratingRepository.getHigestRating(recommendationDto);
//    }
//
//    public List<Movie> recommendMovies(RecommendationDto recommendationDto) {
//      int rating=ratingRepository.getHigestRating(recommendationDto);
//       return movieRepository.findByRating(rating);
//    }

}
