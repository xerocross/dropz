package com.adamfgcross.dropz.controllers;

import com.adamfgcross.dropz.entities.User;
import com.adamfgcross.dropz.repositories.UserRepository;
import com.adamfgcross.dropz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam(value="username") String username,
                                        @RequestParam(value="password") String password) {
        Boolean userCheck = userService.checkUser(username, password);
        if (userCheck) {
            return ResponseEntity.ok("login successful");
        } else {
            return ResponseEntity.ok("login unsuccessful");
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
