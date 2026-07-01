package com.project.eventy.controller;

import java.security.Principal;

import com.project.eventy.entity.User;
import com.project.eventy.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/add")
    public ResponseEntity<?> signUp(@RequestBody User user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(user));
       
    }

    @GetMapping("/api/user/getLoggedInUserDetails")
    public Object getLoggedInUserDetails(Principal principal) {
        String username = principal.getName();

        return userService.getLoggedInUserDetails(username);
    }
    
    

}
