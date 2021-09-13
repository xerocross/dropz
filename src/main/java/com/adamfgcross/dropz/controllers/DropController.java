package com.adamfgcross.dropz.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DropController {




    @PostMapping("/drop")
    public ResponseEntity<String> helloWorld(@RequestParam(value = "drop", defaultValue = "") String text,
                                             @RequestParam(value="username") String username) {



        return ResponseEntity.ok("Added");
    }

}
