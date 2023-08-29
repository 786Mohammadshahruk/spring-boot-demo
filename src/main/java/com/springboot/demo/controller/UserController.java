package com.springboot.demo.controller;


import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get-user-details", method = RequestMethod.GET)
    public List<User> getUserDetails() {
        return userService.getListOfUser();
    }

    @RequestMapping(value = "/get-user-detail", method = RequestMethod.GET, params = "id", headers = "X-admin=true")
    public ResponseEntity<User> getUserDetailsBasedOnId(@RequestParam(name = "id") long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-admin", "false");
        return new ResponseEntity<>(userService.getUserDetailsBasedOnId(userId), headers, HttpStatus.OK);
    }


}
