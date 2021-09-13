package com.adamfgcross.dropz.controllers;

import com.adamfgcross.dropz.entities.User;
import com.adamfgcross.dropz.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestParam(value="username") String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            user.setUsername(username);
            userRepository.save(user);
            return ResponseEntity.ok("saved");
        }
    }
}
