package com.rashmita.movieReview.rating.entity;

import com.rashmita.movieReview.movie.entity.Movie;
import com.rashmita.movieReview.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId",referencedColumnName ="userId")
    private User userId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movieId",referencedColumnName ="movieId")
    private Movie movieId;

    @Column(name="rating")
    private int rating;

}
