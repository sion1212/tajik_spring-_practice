package com.example.demo.response;

import com.example.demo.domain.Post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResponse {
    
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private String userName;

    public static PostResponse from(Post post){
        return PostResponse.builder()
            .id(post.getId())
            .title(post.getTitle())
            .content(post.getContent())
            .userId(post.getUser().getId())
            .userName(post.getUser().getName())
            .build();
    }

}
