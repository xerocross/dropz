package com.adamfgcross.dropz.controllers;

import com.adamfgcross.dropz.services.DropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DropController {


    private final DropService dropService;

    public DropController(DropService dropService) {
        this.dropService = dropService;
    }

    @PostMapping("/drop")
    public ResponseEntity<String> helloWorld(@RequestParam(value = "droptext", defaultValue = "") String droptext,
                                             @RequestParam(value="username") String username) {
        try {
            dropService.saveDrop(droptext, username);
            return ResponseEntity.ok("Added");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
