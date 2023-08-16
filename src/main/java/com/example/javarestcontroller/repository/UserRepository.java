package com.example.javarestcontroller.repository;

import com.example.javarestcontroller.entities.User;
import com.example.javarestcontroller.repository.crudRepository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public User save(User user){
        return userCrudRepository.save(user);
    }

    public void delete(User user){ userCrudRepository.delete(user); }
    
}
