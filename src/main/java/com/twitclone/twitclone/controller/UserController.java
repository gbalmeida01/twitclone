package com.twitclone.twitclone.controller;


import com.twitclone.twitclone.dto.UserRegisterDTO;
import com.twitclone.twitclone.entity.User;
import com.twitclone.twitclone.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@Valid @RequestBody UserRegisterDTO dto) {
        return userService.registerUser(dto);
    }
}
