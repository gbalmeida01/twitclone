package com.twitclone.twitclone.service;

import com.twitclone.twitclone.dto.UserRegisterDTO;
import com.twitclone.twitclone.entity.User;
import com.twitclone.twitclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(UserRegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw  new RuntimeException("Email already registered!");
        }

        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already registered!");
        }

        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .name(dto.getName())
                .password(passwordEncoder.encode(dto.getPassword()))
                .createdAt(LocalDateTime.now())
                .build();

        return userRepository.save(user);
    }
}

