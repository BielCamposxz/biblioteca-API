package com.Livraria.livraria.controller;

import com.Livraria.livraria.DTOs.login.LoginDTO;
import com.Livraria.livraria.entity.UserEntity;
import com.Livraria.livraria.infra.Security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO loginInfo) {
        var usernamePassword =  new UsernamePasswordAuthenticationToken(loginInfo.login(), loginInfo.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token =  tokenService.getToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }

}
