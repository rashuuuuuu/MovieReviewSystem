package com.rashmita.movieReview.movie.service.serviceImpl;

import com.rashmita.movieReview.movie.model.MovieDto;

import com.rashmita.movieReview.movie.model.MovieTitleRequest;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.entity.Status;
import com.rashmita.movieReview.movie.repo.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    Movie movie = new Movie();

    public Movie createMovie(MovieDto movieDto) {

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
        if(movieTitleRequest!=null){
            movieRepository.deleteByTitle(movieTitleRequest);
        }
    }

    public List<Movie> searchByGenre(String movieGenreRequest){
        return movieRepository.findByGenre(movieGenreRequest);
    }
    public List<Movie> searchByTitle(String movieTitleRequest){
        return movieRepository.findByTitle(movieTitleRequest);
    }

    public List<Movie> searchByReleaseDate(String movieReleaseDateRequest){
        return movieRepository.findByReleaseDate(movieReleaseDateRequest);
    }
}

