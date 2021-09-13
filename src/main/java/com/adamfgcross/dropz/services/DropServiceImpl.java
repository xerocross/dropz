package com.adamfgcross.dropz.services;

import com.adamfgcross.dropz.entities.Drop;
import com.adamfgcross.dropz.entities.User;
import com.adamfgcross.dropz.repositories.DropRepository;
import com.adamfgcross.dropz.repositories.UserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DropServiceImpl implements DropService {
    private final DropRepository dropRepository;
    private final UserRepository userRepository;

    public DropServiceImpl(DropRepository dropRepository, UserRepository userRepository) {
        this.dropRepository = dropRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveDrop(Drop drop) {
        dropRepository.save(drop);
    }

    @Override
    public void saveDrop(String dropText, String username) {
        Drop drop = new Drop();
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            drop.setText(dropText);
            drop.setUser(user);
            dropRepository.save(drop);
        } else {
            throw new IllegalArgumentException();
        }

    }
}
