package com.example.springbootdatajpa.controller;

import com.example.springbootdatajpa.entity.User;
import com.example.springbootdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user =  userRepository.getOne(id);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAll(){
        List<User> user =  userRepository.findAll();
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        return userRepository.save(user);
    }
}
