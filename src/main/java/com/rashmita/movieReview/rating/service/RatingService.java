package com.rashmita.movieReview.rating.service;

import com.rashmita.movieReview.movie.model.MovieDto;
import com.rashmita.movieReview.movie.model.MovieIdRequest;
import com.rashmita.movieReview.movie.model.MovieRatingRequest;
import com.rashmita.movieReview.movie.repo.MovieRepository;
import com.rashmita.movieReview.rating.model.RatingDto;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.rating.entity.Rating;
import com.rashmita.movieReview.rating.repo.RatingRepository;
import com.rashmita.movieReview.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MovieRepository movieRepository;

//    public List<Rating> getByRating(int rate) {
//        return ratingRepository.getByRating(rate);
//    }


    public Rating createRating(RatingDto ratingDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        Rating rating = new Rating();
        rating.setRating(ratingDto.getRating());
        rating.setUser(currentUser);
        rating.setMovie(ratingDto.getMovie());
        return ratingRepository.save(rating);
    }

    public List<MovieDto> searchByRating(MovieRatingRequest movieRatingRequest){
        List<Movie> movies=ratingRepository.findByMovieRating(movieRatingRequest.getRating());
        return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }
    public Double getAveragerating(MovieIdRequest movieIdDto) {
        List<Rating> ratings = ratingRepository.findByMovieId(movieIdDto.getMovieId());
        double averageRating = ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);
         return averageRating;
    }
}