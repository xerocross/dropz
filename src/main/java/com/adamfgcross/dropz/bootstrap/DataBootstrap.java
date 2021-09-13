package com.adamfgcross.dropz.bootstrap;

import com.adamfgcross.dropz.entities.Drop;
import com.adamfgcross.dropz.entities.User;
import com.adamfgcross.dropz.repositories.DropRepository;
import com.adamfgcross.dropz.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private final UserRepository userRepository;
    private final DropRepository dropRepository;

    public DataBootstrap(UserRepository userRepository, DropRepository dropRepository) {
        this.userRepository = userRepository;
        this.dropRepository = dropRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User adam = new User();
        adam.setUsername("adam");
        userRepository.save(adam);

        Drop drop = new Drop();
        drop.setText("test text");
        drop.setUser(adam);
        dropRepository.save(drop);


    }
}
