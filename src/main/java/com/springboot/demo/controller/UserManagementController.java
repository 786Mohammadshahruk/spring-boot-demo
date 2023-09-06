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

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Inside Create User");
        return new ResponseEntity<>(userManagementService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userManagementService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/getAll/{id}")
    public ResponseEntity<User> getAllUser(@PathVariable long id) {
        return new ResponseEntity<>(userManagementService.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        return new ResponseEntity<>(userManagementService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable long id) {
        return new ResponseEntity<>(userManagementService.deleteUser(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-all", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAllUser() {
        return new ResponseEntity<>(userManagementService.deleteAllUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-entity", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUserEntity(@RequestBody User user) {
        return new ResponseEntity<>(userManagementService.deleteUserEntity(user), HttpStatus.OK);
    }

}
