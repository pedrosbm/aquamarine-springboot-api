package com.novatech.aquamarine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novatech.aquamarine.model.Login;
import com.novatech.aquamarine.model.User;
import com.novatech.aquamarine.repository.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/Auth")
public class AuthenticationController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping()
    public ResponseEntity<User> get(@RequestBody Login login) {
        String email = login.getUserEmail();
        String password = login.getUserPassword();

        User user = repository.findByUserEmailAndUserPassword(email, password);

        return ResponseEntity.ok(user);
    }
    
}
