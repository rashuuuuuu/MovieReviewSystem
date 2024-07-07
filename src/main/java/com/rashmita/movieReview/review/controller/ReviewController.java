package com.rashmita.movieReview.review.controller;

import com.rashmita.movieReview.review.model.ReviewContent;
import com.rashmita.movieReview.review.model.ReviewDto;

import com.rashmita.movieReview.review.service.serviceImpl.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class ReviewController {
  @Autowired
  private ReviewService reviewService;

    @PostMapping("/createReview")
    public ResponseEntity<String> createReview(@RequestBody ReviewDto reviewDto) {
        reviewService.createReview(reviewDto);
        return ResponseEntity.status(HttpStatus.OK).body("Review created successfully.");
    }


    @GetMapping("/noOfReview")
    public ResponseEntity<String> noOfReview() {
       int count=reviewService.noOfReview();
        return ResponseEntity.status(HttpStatus.OK).body("No Of Review="+count);
    }

    @PostMapping("/deleteReview")
    public ResponseEntity<String> deleteContent(@RequestBody ReviewContent  reviewContent) {
        reviewService.deleteContent(reviewContent);
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully.");
    }

}
