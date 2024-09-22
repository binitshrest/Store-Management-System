package org.binit.productservice.controllers;

import org.binit.productservice.models.userdetails.User;
import org.binit.productservice.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();

    }
    @GetMapping("/{id}")
    public User getAUser(@PathVariable("id") Long id){
        return userService.getAUser(id);
    }

    @PostMapping("")
    public void addTheUser(){

    }

    @PutMapping("")
    public void updateTheUser(){

    }

    @DeleteMapping("")
    public void deleteTheUser(){

    }
}
