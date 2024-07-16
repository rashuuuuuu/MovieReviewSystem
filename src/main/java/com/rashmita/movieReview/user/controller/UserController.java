//package com.rashmita.movieReview.user.controller;
//
//import com.rashmita.movieReview.review.model.ReviewDto;
//import com.rashmita.movieReview.review.service.serviceImpl.ReviewService;
//import com.rashmita.movieReview.user.entity.User;
//import com.rashmita.movieReview.user.service.impl.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.List;
//
//@RequestMapping("/users")
//@RestController
//@RequiredArgsConstructor
//public class UserController {
//    private final UserService userService;
//    private final ReviewService reviewService;
//
//    @GetMapping("/me")
//    public ResponseEntity<User> authenticatedUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        User currentUser = (User) authentication.getPrincipal();
//
//        return ResponseEntity.ok(currentUser);
//    }
//
//    @PostMapping("/createReview")
//    public ResponseEntity<String> createReview(@RequestBody ReviewDto reviewDto) {
//
//       reviewService.createReview(reviewDto);
//       return ResponseEntity.status(HttpStatus.OK).body("Review created successfully.");
//  }
//    @GetMapping("/getALL")
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    public ResponseEntity<List<User>> allUsers() {
//        List <User> users = userService.allUsers();
//
//        return ResponseEntity.ok(users);
//
//    }

//}