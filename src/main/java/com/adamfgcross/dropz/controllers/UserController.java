package com.adamfgcross.dropz.controllers;

import com.adamfgcross.dropz.entities.User;
import com.adamfgcross.dropz.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public ResponseEntity<String> helloWorld(@RequestParam(value="username") String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok("found user");
        } else {
            return ResponseEntity.ok("no user found");
        }
    }
}
