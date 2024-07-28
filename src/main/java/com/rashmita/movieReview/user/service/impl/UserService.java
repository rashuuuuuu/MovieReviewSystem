package com.rashmita.movieReview.user.service.impl;

import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.RegisterUserDto;
import com.rashmita.movieReview.movie.model.MovieDto;
import com.rashmita.movieReview.roleBaseAccessControl.Role;
import com.rashmita.movieReview.roleBaseAccessControl.RoleEnum;
import com.rashmita.movieReview.roleBaseAccessControl.RoleRepository;
import com.rashmita.movieReview.user.entity.User;
import com.rashmita.movieReview.user.model.UserDto;
import com.rashmita.movieReview.user.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> allUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

//    public User createAdministrator(RegisterUserDto input) {
//        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);
//
//        if (optionalRole.isEmpty()) {
//            return null;
//        }
//
//        var user = new User();
//        user.setFullName(input.getFullName());
//        user.setEmail(input.getEmail());
//        user.setPassword(passwordEncoder.encode(input.getPassword()));
//        user.setRole(optionalRole.get());
//        user.setAddress(input.getAddress());
//        user.setPhone(input.getPhone());
//        user.setPicture(input.getPicture());
//        user.setCreatedAt(new Date());
//        user.setUpdatedAt(new Date());
//
//        return userRepository.save(user);
//    }
//    public  UserDto authenticatedUser(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDto currentUser = (UserDto) authentication.getPrincipal();
//              UserDto savedUserDto = modelMapper.map(currentUser, UserDto.class);
//              return savedUserDto;
//
//    }
}
