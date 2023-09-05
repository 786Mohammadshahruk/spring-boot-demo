package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-management")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userManagementService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userManagementService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<User> getAllUser(@PathVariable long id) {
        return new ResponseEntity<>(userManagementService.findById(id), HttpStatus.OK);
    }


}
