package com.example.javarestcontroller.repository.crudRepository;

import com.example.javarestcontroller.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository <User, Integer> {
    
}
