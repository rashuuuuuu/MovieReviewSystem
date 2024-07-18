package com.rashmita.movieReview.user.model;

import com.rashmita.movieReview.roleBaseAccessControl.RoleEnum;

import com.rashmita.movieReview.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private String username;

    private String password;

    private String email;

    private String picture;


}
