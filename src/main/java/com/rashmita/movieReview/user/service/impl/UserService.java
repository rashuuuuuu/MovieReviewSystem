package com.rashmita.movieReview.user.service.impl;

import com.rashmita.movieReview.user.model.UserDto;
import com.rashmita.movieReview.user.model.UserLoginDto;
import com.rashmita.movieReview.user.entity.Role;
import com.rashmita.movieReview.user.entity.User;
import com.rashmita.movieReview.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }
//    public User registration(UserDto userDto){
//        User user = new User();
//        user.setUserName(userDto.getUsername());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setRole(Role.USER);
//        return userRepository.save(user);
//    }
//    public String login(UserLoginDto userLoginDto) {
//        User user = new User();
//        if (user.getEmail().equals(userLoginDto.getEmail()) &&
//                user.getPassword().equals(userLoginDto.getPassword())) {
//           return "login success";
//
//        }
//        else{
//            return "login fail";
//        }
//    }

}