package com.lcwd.user.service.controllers;


import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody  User user){

        User user1 = userService.saveUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.CREATED);


    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){

        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);


    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId){

        User user = userService.getUser(userId);
        return new ResponseEntity<User>(user,HttpStatus.OK);


    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId){

        userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted user succesfully",HttpStatus.OK);





    }






}
