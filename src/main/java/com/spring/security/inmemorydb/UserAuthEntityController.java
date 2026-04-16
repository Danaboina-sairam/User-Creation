package com.spring.security.inmemorydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthEntityController {

    @Autowired
    UserAuthEntityService userAuthEntityService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserAuthEntity userAuthEntity){
        userAuthEntity.setPassword(passwordEncoder.encode(userAuthEntity.getPassword()));

        userAuthEntityService.save(userAuthEntity);

        return ResponseEntity.ok("User registered successfully!");
    }
}
