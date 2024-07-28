package com.rashmita.movieReview.review.entity;

import com.rashmita.movieReview.movie.entity.Status;
import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",referencedColumnName ="id")
    private User User;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id",referencedColumnName ="id")
    private Movie Movie;

    @Column(name="content")
    private String content;

    @Column(name="rating")
    private Double rating;

    @Column(name="timestamp")
    private Date timestamp;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
