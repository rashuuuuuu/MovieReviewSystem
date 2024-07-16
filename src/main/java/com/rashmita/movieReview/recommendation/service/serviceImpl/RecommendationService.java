package com.rashmita.movieReview.recommendation.service.serviceImpl;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.model.MovieDto;
import com.rashmita.movieReview.movie.repo.MovieRepository;
import com.rashmita.movieReview.rating.entity.Rating;
import com.rashmita.movieReview.rating.repo.RatingRepository;

import com.rashmita.movieReview.recommendation.model.RecommendationDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@RequiredArgsConstructor
@Service
public class RecommendationService {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public List<Movie> getRecommendations(RecommendationDto recommendationDto) {
         Long userId=recommendationDto.getUserId();
      int highestRating = ratingRepository.findHighestRatingByUserId(userId);
        List<Rating> ratedMovies = ratingRepository.getByRating(highestRating);
        if (!ratedMovies.isEmpty()) {
            String genre = ratedMovies.get(0).getMovie().getGenre();
            return movieRepository.findByGenre(genre);
        }
        return List.of( new Movie());
    }
}