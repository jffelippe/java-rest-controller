package com.example.javarestcontroller.controller;
import com.example.javarestcontroller.entities.User;
import com.example.javarestcontroller.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/some")
    List<String> all() {
        List<String> employees;
        employees = new ArrayList<String>();
        employees.add("JuanPa");
        employees.add("JuanFe");
        employees.add("Elver Gomez Torba");
        return employees;
    } 
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") int userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {

        return userService.save(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int userId) {
        return userService.delete(userId);
    }
}
