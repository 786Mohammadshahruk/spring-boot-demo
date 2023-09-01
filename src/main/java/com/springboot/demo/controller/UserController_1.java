package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController_1 {
    @Autowired
    private UserService userService;
    @Value("${header.name}")
    String header;

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam(name = "firstName", defaultValue = "yeteg") String firstName,
                                        @RequestParam(name = "lastName", required = false) String lastName,
                                        @RequestParam(name = "userName") List<String> name,
                                        @RequestParam(name = "id") Integer id,
                                        @RequestHeader(name = "Admin") String admin) {
        if (!admin.equals(header)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        System.out.println("FirstName : " + firstName + ", LAST NAME : " + lastName + ", Name : " + name + ", ID : " + id);
        return new ResponseEntity<>(userService.getUserDetailsBasedOnName(firstName), HttpStatus.OK);
    }

}
