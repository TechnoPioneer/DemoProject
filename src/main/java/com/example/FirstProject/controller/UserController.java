package com.example.FirstProject.controller;

import com.example.FirstProject.model.Users;
import com.example.FirstProject.serviceImpl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestParam(required = true) String userName, @RequestParam(required = true) String password) {

        Users users = userDetailsService.registerUser(userName, password);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
