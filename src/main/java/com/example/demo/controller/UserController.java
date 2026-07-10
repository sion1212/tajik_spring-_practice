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

import com.example.demo.request.UserUpdateRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/read/{id}")
    public UserResponse read(@PathVariable("id") Long id){
        return userService.read(id);
    }

    @GetMapping("/readAll")
    public List<UserResponse> readAll(){
        return userService.readAll();
    }

    @PostMapping("/add")
    public String create(@RequestBody UserRequest userRequest){
        return userService.create(userRequest);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody UserUpdateRequest userUpdateRequest){
        return userService.update(id,userUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return userService.delete(id);
    }
    
}
