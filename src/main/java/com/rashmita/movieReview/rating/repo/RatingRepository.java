package com.rashmita.movieReview.rating.repo;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.model.MovieDto;
import com.rashmita.movieReview.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository  extends JpaRepository<Rating, Long> {

    List<MovieDto> findByRating(int movieRatingRequest);

    List<Rating> findByMovieId(Movie movieId);

    @Query("SELECT MAX(r.rating) FROM Rating r WHERE r.user.id = :userId")
    int findHighestRatingByUserId(Long userId);

    List<Rating> getByRating(int rating);
}

