package com.rashmita.movieReview.rating.repo;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.rating.entity.Rating;
import com.rashmita.movieReview.recommendation.model.RecommendationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository  extends JpaRepository<Rating, Long> {

    List<Movie> findByRating(int movieRatingRequest);

    List<Rating> findByMovieId(Movie movieId);

//    Double getHigestRating(RecommendationDto recommendationDto);
//
//    @Query("SELECT AVG(r.rating) FROM Rating r")
//    Double findAverageRating();

//
//    List<Rating> findHighestRatingOfUserByUserId(Long userId);
}
