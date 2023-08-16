package com.example.javarestcontroller.service;

import com.example.javarestcontroller.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.javarestcontroller.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){ return userRepository.getAll();}
    public Optional<User> getUser(int userId){
        return userRepository.getUser(userId);
    }
    
    public User save(User user){
        if (user.getIdUser()==null){
            return userRepository.save(user);
        }else {
            Optional<User> user1 = userRepository.getUser(user.getIdUser());
            if (user1.isEmpty()){
                return  userRepository.save(user);
            }else {
                return user;
            }
        }
    }

    public User updateUser(User user){
        if (user.getIdUser()!=null) {
            Optional<User> q = userRepository.getUser(user.getIdUser());
            if (!q.isEmpty()) {
                if (user.getEmail() != null && user.getEmail().contains("@")) {
                    q.get().setEmail(user.getEmail());
                }
                if (user.getName() != null) {
                    q.get().setName(user.getName());
                }
                return userRepository.save(q.get());
            }
        }
         return user;
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<User>p= userRepository.getUser(id);
        if (p.isPresent()){
            userRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
