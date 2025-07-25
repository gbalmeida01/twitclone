package com.twitclone.twitclone.dto;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String content;
    private Long userId;
}
