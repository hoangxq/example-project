package com.example.exampleproject.repository;

import com.example.exampleproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<User> findByUsername(String username);
}