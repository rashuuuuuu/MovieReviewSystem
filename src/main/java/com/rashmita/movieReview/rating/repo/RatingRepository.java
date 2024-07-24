package com.rashmita.movieReview.rating.repo;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository  extends JpaRepository<Rating, Long> {

    @Query("SELECT m FROM Movie m JOIN Rating r ON m.id = r.movie.id WHERE r.rating = :rating")
    List<Movie> findByMovieRating(int rating);

    List<Rating> findByMovieId(Long movieId);

    @Query("SELECT MAX(r.rating) FROM Rating r WHERE r.user.id = :userId")
    int findHighestRatingByUserId(Long userId);

    List<Rating> findRatingByRating(int rating);
}

