package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    
    public List<Post> findAllByUser(User user);

}
