package com.example.exampleproject.service.component;

import com.example.exampleproject.model.User;
import com.example.exampleproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getCurrentAuditor() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }
}
