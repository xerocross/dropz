package com.adamfgcross.dropz.repositories;


import com.adamfgcross.dropz.entities.Drop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DropRepository extends CrudRepository<Drop, Long> {
}
