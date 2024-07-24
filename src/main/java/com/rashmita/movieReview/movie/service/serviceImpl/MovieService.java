package com.rashmita.movieReview.movie.service.serviceImpl;

import com.rashmita.movieReview.movie.model.*;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.movie.entity.Status;
import com.rashmita.movieReview.movie.repo.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public Movie createMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setGenre(movieDto.getGenre());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setCast(movieDto.getCast());
        movie.setDirector(movieDto.getDirector());
        movie.setProducer(movieDto.getProducer());
        movie.setPicture(movieDto.getPicture());
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
            movie.setDirector(movieDto.getDirector());
            movie.setProducer(movieDto.getProducer());
            movie.setPicture(movieDto.getPicture());
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
        public List<MovieDto> searchByGenre (String movieGenreRequest){

         List<Movie> movies= movieRepository.findByGenre(movieGenreRequest);
            return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                    .collect(Collectors.toList());
        }
        public List<MovieDto> searchByTitle (String movieTitleRequest){
            Optional<Movie> movies= movieRepository.findByTitle(movieTitleRequest);
            return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                    .collect(Collectors.toList());

        }
    public List<MovieDto> getDetailsById(Long movieIdRequest){
//        Movie moviee=new Movie();
        Optional<Movie> movies= movieRepository.getDetailsById(movieIdRequest);
        if(movies.isPresent()){
            Movie movie = movies.get();

            int counter = movie.getViewCount() != null ? movie.getViewCount() : 0;
            counter++;

            log.info("Count: {}",counter);
            movie.setViewCount(counter);
            movieRepository.save(movie);
        }
        return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }


    public List<MovieDto> searchByReleaseDate (String movieReleaseDateRequest){
            List<Movie> movies=movieRepository.findByReleaseDate(movieReleaseDateRequest);
            return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                    .collect(Collectors.toList());
        }
        public List<MovieDto> getAllMovie () {
            List<Movie> movies= movieRepository.findAll();
            return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                    .collect(Collectors.toList());
            
        }


    public List<MovieDto> searchMovies(MovieSearchCriteria criteria) {
        if (criteria.getGenre() != null) {
            List<Movie> movies= movieRepository.findByGenre(criteria.getGenre());
            return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                    .collect(Collectors.toList());
        } else if (criteria.getTitle() != null) {
            List<Movie> movies= movieRepository.findByTitle(criteria.getTitle())
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());
            return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                    .collect(Collectors.toList());

        } else if (criteria.getReleaseDate() != null) {
            List<Movie> movies=movieRepository.findByReleaseDate(criteria.getReleaseDate());
            return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                    .collect(Collectors.toList());

        } else {
            return Collections.emptyList(); // Or fetch all movies, or handle as needed
        }
    }



//    public void createView(int counter){
//        Movie movie=new Movie();
//        int viewCount = counter;
//        while(movie!=null) {
//            movie.setViewCount(viewCount);
//            movieRepository.save(movie);
//        }
//    }
    public List<MovieDto> trending() {
        List<Movie> movies= movieRepository.findAllByOrderByViewCountDesc();
        return movies.stream().map((movie) -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());

    }
}




