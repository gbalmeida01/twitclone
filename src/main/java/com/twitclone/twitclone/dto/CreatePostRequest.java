package com.twitclone.twitclone.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostRequest {

    @JsonProperty("content")
    private String content;

    @JsonProperty("user_id")
    private Long userId;
}
