package com.springboot.demo.controller;


import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @RequestMapping(value = "/create-user", method = RequestMethod.POST, headers = "X-admin=true",
            consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<List<User>> createUser(@RequestBody User user) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-admin", "false");
        System.out.println("Inside Controller " + user);
        return new ResponseEntity<>(userService.createUser(user), headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/get-user/{userId}/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable(name = "userId") long id,
                                        @PathVariable(name = "name") String name) {
        System.out.println("UserId : " + id + "  Name : " + name);
        return new ResponseEntity<>(userService.getUserDetailsBasedOnId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/getPdf/{pdf_type:(?:tnc|account_statement)}", method = RequestMethod.GET)
    public ResponseEntity<?> getPdf(@PathVariable(name = "pdf_type") String pdf_type) {
        if (pdf_type.equals("tnc")) {
            System.out.println("TNC");
        } else if (pdf_type.equals("account_statement")) {
            System.out.println("account_statement");
        }
        return new ResponseEntity<>("OKKKK", HttpStatus.OK);
    }


    @RequestMapping(value = "/get-user_1", method = RequestMethod.GET)
    public ResponseEntity<User> getUserOptionUseCase(
            @PathVariable(name = "userId", required = false) String id) {
        System.out.println("UserId : " + id);
        if (id == null) {
            id = "1";
        }
        return new ResponseEntity<>(userService.getUserDetailsBasedOnId(Long.parseLong(id)), HttpStatus.OK);
    }


}
