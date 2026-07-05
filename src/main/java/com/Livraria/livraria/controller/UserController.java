package com.Livraria.livraria.controller;

import com.Livraria.livraria.DTOs.user.CreateUserDTO;
import com.Livraria.livraria.entity.UserEntity;
import com.Livraria.livraria.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> createNewUser(@RequestBody CreateUserDTO createUserDTO) {
        this.userService.createUser(createUserDTO);
        return ResponseEntity.ok().body("User created successfully");
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
