package com.rashmita.movieReview.rating.service;

import com.rashmita.movieReview.movie.repo.MovieRepository;
import com.rashmita.movieReview.rating.model.RatingDto;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.rating.entity.Rating;
import com.rashmita.movieReview.rating.repo.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@RequiredArgsConstructor
@Service
public class RatingService {

    public final RatingRepository ratingRepository;


    public List<Movie> searchByRating(int movieRatingRequest) {
        return ratingRepository.findByRating(movieRatingRequest);
    }

    public Rating createRating(RatingDto ratingDto) {
        Rating rating = new Rating();
        rating.setRating(ratingDto.getRating());
        rating.setUserId(ratingDto.getUserId());
        rating.setMovieId(ratingDto.getMovieId());
        return ratingRepository.save(rating);
    }

    public Double getAveragerating(Movie movieId) {
        List<Rating> ratings = ratingRepository.findByMovieId(movieId);
        double averageRating = ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);
         return averageRating;
    }
}