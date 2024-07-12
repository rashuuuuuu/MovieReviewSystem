package com.rashmita.movieReview.user.repo;

import com.rashmita.movieReview.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OldUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByFullName(String fullName);
}
