package com.twitclone.twitclone.service;


import com.twitclone.twitclone.dto.CreatePostRequest;
import com.twitclone.twitclone.entity.Post;
import com.twitclone.twitclone.entity.User;
import com.twitclone.twitclone.repository.PostRepository;
import com.twitclone.twitclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void createPost(CreatePostRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        Post post = new Post();
        post.setContent(request.getContent());
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());

        postRepository.save(post);
    }
}

