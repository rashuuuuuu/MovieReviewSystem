//package com.rashmita.movieReview.viewCount.service;
//
//import com.rashmita.movieReview.movie.entity.Movie;
//import com.rashmita.movieReview.movie.model.MovieDto;
//import com.rashmita.movieReview.viewCount.entity.ViewCountEntity;
//import com.rashmita.movieReview.viewCount.repo.ViewCountRepo;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@RequiredArgsConstructor
//@Service
//public class ViewCountService {
//    @Getter
//    private Movie movie;
//    private  ViewCountRepo viewCountRepo;
//
//
//    public ViewCountService( ViewCountRepo viewCountRepo) {
//        this.viewCountRepo = viewCountRepo;
//
//    }
//    public void createView(int counter){
//       ViewCountEntity view=new ViewCountEntity();
//        view.setView(counter);
//        viewCountRepo.save(view);
//
//    }
//    public List<MovieDto> trending() {
//        return viewCountRepo.findAllByOrderByViewCountDesc();
//    }
//}
