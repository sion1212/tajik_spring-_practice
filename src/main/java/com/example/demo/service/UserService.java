package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.request.UserUpdateRequest;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String create(UserRequest userRequest){
        User user = User.from(userRequest);
        user = userRepository.save(user);
        return "success";
    }

    public UserResponse read(Long id){
        User user = userRepository.findById(id).orElse(null);
        return UserResponse.from(user);
    }

    public List<UserResponse> readAll(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserResponse::from).toList();
    }

    @Transactional
    public String update(Long id, UserUpdateRequest userUpdateRequest){
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setName(userUpdateRequest.getName());
            user.setEmail(userUpdateRequest.getEmail());
        }else{
            return "request user is not exist";
        }
        return "success";
    }

    public String delete(Long id){
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            userRepository.deleteById(id);
        }else{
            return "request user is not exist";
        }
        return "success";
    }
    
}
