package com.rashmita.movieReview.user.model;

import com.rashmita.movieReview.roleBaseAccessControl.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private String username;

    private String password;

    private String email;


}
