package com.rashmita.movieReview.review.service.serviceImpl;

import com.rashmita.movieReview.movie.entity.Status;
import com.rashmita.movieReview.review.entity.Review;
import com.rashmita.movieReview.review.model.ReviewContent;
import com.rashmita.movieReview.review.model.ReviewDto;

import com.rashmita.movieReview.review.repo.ReviewRepository;
import com.rashmita.movieReview.user.entity.User;
import com.rashmita.movieReview.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {
@Autowired
    private ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    Review review=new Review();
    @Autowired
    private ModelMapper modelMapper;


    public Review createReview(ReviewDto reviewDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        Review review = new Review();
        review.setUser(currentUser);
        review.setRating(reviewDto.getRating());
        review.setMovie(reviewDto.getMovieIdRequest());
        review.setTimestamp(new Date(System.currentTimeMillis()));
        review.setContent(reviewDto.getContent());
        review.setStatus(Status.CREATED);

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
    public List<ReviewDto> getAllReview () {
        List<Review> reviews= reviewRepository.findAll();
        return reviews.stream().map((review) -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());

    }
    }


