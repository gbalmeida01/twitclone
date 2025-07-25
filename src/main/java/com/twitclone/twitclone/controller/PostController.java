package com.twitclone.twitclone.controller;

import com.twitclone.twitclone.dto.CreatePostRequest;
import com.twitclone.twitclone.entity.Post;
import com.twitclone.twitclone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody CreatePostRequest request) {
        postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
