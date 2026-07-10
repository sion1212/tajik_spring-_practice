package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.PostRequest;
import com.example.demo.request.PostUpdateRequest;
import com.example.demo.response.PostResponse;
import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/userPosts/{userId}")
    public List<PostResponse> userPosts(@PathVariable("userId") Long userId){
        return postService.readAllByuserId(userId);
    }

    @GetMapping("/read/{id}")
    public PostResponse readPost(@PathVariable("id") Long id){
        return postService.read(id);
    }

    @GetMapping("/readAll")
    public List<PostResponse> readAllPost(){
        return postService.readAll();
    }

    @PostMapping("/add")
    public String addPost(@RequestBody PostRequest postRequest){
        return postService.addPost(postRequest);
    }

    @PutMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Long id, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.update(id, postUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id){
        return postService.delete(id);
    }
}
