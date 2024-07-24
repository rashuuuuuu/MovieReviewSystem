//package com.rashmita.movieReview.viewCount.entity;
//
//import com.rashmita.movieReview.movie.entity.Movie;
//import jakarta.persistence.*;
//
//import jakarta.persistence.Entity;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="Count")
//
//public class ViewCountEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "movie_id",referencedColumnName ="id")
//    private Movie movie;
//
//    @Column(name="viewCount")
//    private int view;
//
//
//
//}
