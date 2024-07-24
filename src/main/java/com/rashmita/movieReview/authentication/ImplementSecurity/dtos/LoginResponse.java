package com.rashmita.movieReview.authentication.ImplementSecurity.dtos;

import com.rashmita.movieReview.movie.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String token;
//    private Status status;

    private long expiresIn;

    public String getToken() {
        return token;
    }

    // Getters and setters...
}