package com.rashmita.movieReview.authentication.ImplementSecurity.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginUserDto {
    private String email;

    private String password;

}