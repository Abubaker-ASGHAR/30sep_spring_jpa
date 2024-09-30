package com.example.spacedemo.controller;

import com.example.spacedemo.service.UserService;
import com.example.spacedemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/search")
    public Page<User> searchUsers(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required=false) Integer minAge,
                                  @RequestParam(required = false) Integer maxAge,
                                  @RequestParam(defaultValue = "id") String sortBy,
                                  @RequestParam(defaultValue = "asc") String sortDir,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        return userService.searchUsers(name, email, minAge, maxAge, sortBy, sortDir, page, size);

    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
