package com.rashmita.movieReview.user.model;

import com.rashmita.movieReview.user.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    @NotBlank(message="username must be filled")
    private String username;

    @NotBlank(message="password can't be blank")
    private String password;

    private String email;

    private Role role;

}
