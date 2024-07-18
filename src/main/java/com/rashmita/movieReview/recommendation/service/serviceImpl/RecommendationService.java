package com.rashmita.movieReview.recommendation.service.serviceImpl;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.model.MovieDto;
import com.rashmita.movieReview.movie.repo.MovieRepository;
import com.rashmita.movieReview.rating.entity.Rating;
import com.rashmita.movieReview.rating.repo.RatingRepository;

import com.rashmita.movieReview.recommendation.model.RecommendationDto;
import com.rashmita.movieReview.user.entity.User;
import jakarta.transaction.Transactional;
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
public class RecommendationService {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public List<MovieDto> getRecommendations() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
         Long userId=currentUser.getId();
      int highestRating = ratingRepository.findHighestRatingByUserId(userId);
        List<Rating> ratedMovies = ratingRepository.findRatingByRating(highestRating);
        if (!ratedMovies.isEmpty()) {
            String genre = ratedMovies.get(0).getMovie().getGenre();
           List<Movie> movies=movieRepository.findByGenre(genre);
            return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                    .collect(Collectors.toList());
        }
        return List.of( new MovieDto());
    }
}