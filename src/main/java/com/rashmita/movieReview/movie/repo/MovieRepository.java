package com.rashmita.movieReview.movie.repo;

import com.rashmita.movieReview.movie.model.MovieTitleRequest;
import com.rashmita.movieReview.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    void deleteByTitle(MovieTitleRequest movieTitleRequest);

    List<Movie> findByTitle(String movieTitleRequest);

    List<Movie> findByGenre(String movieGenreRequest);

    List<Movie> findByReleaseDate(String movieReleaseDateRequest);
//
//    List<Movie> findByRating(int rating);
}
