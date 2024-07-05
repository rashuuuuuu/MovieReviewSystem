package com.rashmita.movieReview.review.service.serviceImpl;

import com.rashmita.movieReview.movie.entity.Status;
import com.rashmita.movieReview.rating.model.RatingDto;
import com.rashmita.movieReview.review.entity.Review;
import com.rashmita.movieReview.review.model.ReviewContent;
import com.rashmita.movieReview.review.model.ReviewDto;

import com.rashmita.movieReview.rating.repo.RatingRepository;
import com.rashmita.movieReview.review.repo.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@RequiredArgsConstructor
@Service
public class ReviewService {
@Autowired
    private ReviewRepository reviewRepository;
    Review review=new Review();
    public Review createReview(ReviewDto reviewDto) {
    review.setUserId(reviewDto.getUserId());
    review.setRating(reviewDto.getRating());
    review.setMovieId(reviewDto.getMovieId());
    review.setTimestamp(new Date(System.currentTimeMillis()));
    review.setContent(reviewDto.getContent());
    return reviewRepository.save(review);

    }

    @Transactional(readOnly = true)
    public int noOfReview(){
        return (int)reviewRepository.count();
    }

    public void deleteContent(ReviewContent reviewContent){
        if(reviewContent!=null){
            review.setStatus(Status.DELETED);
        }
    }

}
