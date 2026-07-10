package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.PostRequest;
import com.example.demo.request.PostUpdateRequest;
import com.example.demo.response.PostResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public String addPost(PostRequest postRequest){
        User user = userRepository.findById(postRequest.getUserId()).orElse(null);
        Post post = Post.from(user, postRequest);
        postRepository.save(post);
        return "success";
    }

    public List<PostResponse> readAllByuserId(Long userId){
        User user = userRepository.findById(userId).orElse(null);
        List<Post> posts = postRepository.findAllByUser(user);
        return posts.stream().map(PostResponse::from).toList();
    }

    public PostResponse read(Long id){
        Post requestPost = postRepository.findById(id).orElse(null);
        PostResponse response = PostResponse.from(requestPost);
        return response;
    }

    public List<PostResponse> readAll(){
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostResponse::from).toList();
    }

    @Transactional
    public String update(Long id, PostUpdateRequest postUpdateRequest){
        Post requestPost = postRepository.findById(id).orElse(null);
        if(requestPost != null){
            requestPost.setTitle(postUpdateRequest.getTitle());
            requestPost.setContent(postUpdateRequest.getContent());
        }else{
            return "fail to find request post";
        }
        return "success";
    }

    public String delete(Long id){
        Post requePost = postRepository.findById(id).orElse(null);
        if(requePost != null){
            postRepository.deleteById(id);
        }else{
            return "fail to find the request post";
        }
        
        return "success";
    }
}
