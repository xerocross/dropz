package com.adamfgcross.dropz.controllers;

import com.adamfgcross.dropz.entities.Drop;
import com.adamfgcross.dropz.services.DropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DropController {


    private final DropService dropService;

    public DropController(DropService dropService) {
        this.dropService = dropService;
    }

    @PostMapping("/drop")
    public ResponseEntity<String> postDrop(@RequestParam(value = "droptext", defaultValue = "") String droptext,
                                             @RequestParam(value="username") String username) {
        try {
            dropService.saveDrop(droptext, username);
            return ResponseEntity.ok("Added");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/drop")
    public ResponseEntity<List<Drop>> getDrop(@RequestParam(value = "droptext", defaultValue = "") String droptext,
                                             @RequestParam(value="username") String username) {
        try {
            List<Drop> drops = dropService.getDrops(droptext, username);
            return ResponseEntity.ok(drops);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
