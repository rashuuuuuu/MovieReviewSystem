//package com.rashmita.movieReview.authentication.ImplementSecurity.controllers;
//
//import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.LoginResponse;
//import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.LoginUserDto;
//import com.rashmita.movieReview.authentication.ImplementSecurity.dtos.RegisterUserDto;
//import com.rashmita.movieReview.authentication.ImplementSecurity.services.AuthenticationService;
//import com.rashmita.movieReview.authentication.ImplementSecurity.services.JwtService;
//import com.rashmita.movieReview.user.entity.User;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequestMapping("/movieReview/auth")
//@RestController
//public class AuthenticationController {
//    private final JwtService jwtService;
//    private final AuthenticationService authenticationService;
//
//    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
//        this.jwtService = jwtService;
//        this.authenticationService = authenticationService;
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) throws Exception {
//        User registeredUser = authenticationService.signup(registerUserDto);
//
//        return ResponseEntity.ok(registeredUser);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
//        User authenticatedUser = authenticationService.authenticate(loginUserDto);
//
//        String jwtToken = jwtService.generateToken(authenticatedUser);
//
//        LoginResponse loginResponse = new LoginResponse();
//        loginResponse.setToken(jwtToken);
//      loginResponse.setExpiresIn(jwtService.getExpirationTime());
//
//        return ResponseEntity.ok(loginResponse);
//    }
//}