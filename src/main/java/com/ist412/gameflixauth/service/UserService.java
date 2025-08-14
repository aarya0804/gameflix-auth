package com.ist412.gameflixauth.service;

import com.ist412.gameflixauth.model.User;
import com.ist412.gameflixauth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Registration: validate, prevent duplicates, hash, save
    public String register(String username, String password) {
        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            return "Invalid input";
        }

        String clean = username.trim();

        if (userRepository.existsByUsername(clean)) {
            return "Username already exists";
        }

        String hash = passwordEncoder.encode(password);
        userRepository.save(new User(clean, hash));
        return "User registered successfully";
    }

    // Login: find user and compare plain password to stored hash
    public String login(String username, String password) {
        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            return "Invalid username or password";
        }

        return userRepository.findByUsername(username.trim())
                .map(u -> passwordEncoder.matches(password, u.getPasswordHash())
                        ? "Login successful"
                        : "Invalid username or password")
                .orElse("Invalid username or password");
    }
}