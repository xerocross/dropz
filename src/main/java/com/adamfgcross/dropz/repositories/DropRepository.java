package com.adamfgcross.dropz.repositories;


import com.adamfgcross.dropz.entities.Drop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DropRepository extends CrudRepository<Drop, Long> {

    List<Drop> findByTextContains(String text);
}
