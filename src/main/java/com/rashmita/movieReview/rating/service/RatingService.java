package com.rashmita.movieReview.rating.service;

import com.rashmita.movieReview.movie.model.MovieDto;
import com.rashmita.movieReview.rating.model.RatingDto;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.rating.entity.Rating;
import com.rashmita.movieReview.rating.repo.RatingRepository;
import com.rashmita.movieReview.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class RatingService {

    public final RatingRepository ratingRepository;


    public List<Rating> getByRating(int rate) {
        return ratingRepository.getByRating(rate);
    }
    public List<MovieDto> searchByRating(int movieRatingRequest) {
        return ratingRepository.findByRating(movieRatingRequest);
    }

    public Rating createRating(RatingDto ratingDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Rating rating = new Rating();
        rating.setRating(ratingDto.getRating());
        rating.setUser(currentUser);
        rating.setMovie(ratingDto.getMovieId());
        return ratingRepository.save(rating);
    }

    public Double getAveragerating(Movie movieId) {
        List<Rating> ratings = ratingRepository.findByMovieId(movieId);
        double averageRating = ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);
         return averageRating;
    }
}