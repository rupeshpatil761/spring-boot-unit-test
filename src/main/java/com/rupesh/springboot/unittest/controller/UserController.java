package com.rupesh.springboot.unittest.controller;

import com.rupesh.springboot.unittest.model.User;
import com.rupesh.springboot.unittest.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name="id", required = true) Long id){
        logger.info("GetUserById user id : {}",id);
        return userService.getUserById(id);
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name="id", required = true) Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(name="id", required = true) Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }
}
