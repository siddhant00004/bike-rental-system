package com.bikerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikerental.entity.AppUser;
import com.bikerental.repository.AppUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private AppUserRepository userRepository;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

}
