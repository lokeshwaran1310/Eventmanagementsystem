package com.example.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventmanagement.domain.User;

public interface  UserRepository extends JpaRepository<User, Long>{
    boolean existsByEmail(String email);
}
