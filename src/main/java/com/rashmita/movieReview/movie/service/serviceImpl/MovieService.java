package com.rashmita.movieReview.movie.service.serviceImpl;

import com.rashmita.movieReview.movie.model.*;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.entity.Status;
import com.rashmita.movieReview.movie.repo.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;


    public Movie createMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setGenre(movieDto.getGenre());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setCast(movieDto.getCast());
        movie.setCrew(movieDto.getCrew());
        movie.setSynopsis(movieDto.getSynopsis());
        movie.setStatus(Status.CREATED);
        return movieRepository.save(movie);
    }

    public Movie updateMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        if (movieDto.getTitle() != null) {
            movie.setTitle(movieDto.getTitle());
            movie.setGenre(movieDto.getGenre());
            movie.setReleaseDate(movieDto.getReleaseDate());
            movie.setCast(movieDto.getCast());
            movie.setCrew(movieDto.getCrew());
            movie.setSynopsis(movieDto.getSynopsis());

        }
        return movieRepository.save(movie);
    }
    public void deleteMovie(MovieTitleRequest movieTitleRequest){
        Optional<Movie> movie = movieRepository.getByTitle(movieTitleRequest.getTitle());
        if(movie.isPresent()){
            Movie foundMovie = movie.get();
            foundMovie.setStatus(Status.DELETED);
            movieRepository.save(foundMovie);
        }
        else{
            System.out.println("no");
        }
    }
        public List<Movie> searchByGenre (String movieGenreRequest){
            return  movieRepository.findByGenre(movieGenreRequest);
        }
        public Optional<Movie> searchByTitle (String movieTitleRequest){
            return movieRepository.findByTitle(movieTitleRequest);

        }

        public List<Movie> searchByReleaseDate (String movieReleaseDateRequest){
            return movieRepository.findByReleaseDate(movieReleaseDateRequest);

        }
        public List<Movie> getAllMovie () {
            return movieRepository.findAll();
            
        }


    public List<Movie> searchMovies(MovieSearchCriteria criteria) {
        if (criteria.getGenre() != null) {
            return movieRepository.findByGenre(criteria.getGenre());
        } else if (criteria.getTitle() != null) {
            return movieRepository.findByTitle(criteria.getTitle())
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());
        } else if (criteria.getReleaseDate() != null) {
           return movieRepository.findByReleaseDate(criteria.getReleaseDate());

        } else {
            return Collections.emptyList(); // Or fetch all movies, or handle as needed
        }
    }



    }



