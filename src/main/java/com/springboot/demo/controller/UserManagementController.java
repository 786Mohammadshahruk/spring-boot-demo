package com.springboot.demo.controller;

import com.springboot.demo.dtos.UserDto;
import com.springboot.demo.entity.User;
import com.springboot.demo.exception.CustomException;
import com.springboot.demo.model.response.MetaData;
import com.springboot.demo.model.response.ResourceData;
import com.springboot.demo.model.response.UserResponseModel;
import com.springboot.demo.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/user-management")
@Slf4j
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseModel> createUser(@RequestBody User user) {
        System.out.println("Inside Create User");

        MetaData metaData = MetaData.builder()
                .status("SUCCESS")
                .code("200 OK")
                .message("SUCCESS")
                .version("v1")
                .build();
        ResourceData resourceData = new ResourceData();
        resourceData.setData(userManagementService.createUser(user));
        return new ResponseEntity<>(getResponseData(metaData, resourceData), HttpStatus.CREATED);
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

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserByName(@PathVariable String name) {
        return new ResponseEntity<>(userManagementService.findByName(name), HttpStatus.OK);

    }

    @RequestMapping(value = "/getUsersByPrice/{price}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserByName(@PathVariable BigDecimal price) {
        return new ResponseEntity<>(userManagementService.findByPrice(price), HttpStatus.OK);
    }


    @RequestMapping(value = "/getUsersByMobileNumber/{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseModel> getUserByMobileNumber(@PathVariable String number,
                                                                   @RequestParam String type) throws Exception {

        log.info("Inside Controller");
        if (type.equals("test")) {
            throw new CustomException("Test fail");
        }
        MetaData metaData = null;
        ResourceData resourceData = null;
        List<User> listUser;
        if (type.equals("JPQL")) {
            listUser = userManagementService.findByMobileNumberWithJPQL(number);

        } else {
            listUser = userManagementService.findByMobileNumberWithNative(number);
        }
        metaData = MetaData.builder()
                .status("SUCCESS")
                .code("200 OK")
                .message("SUCCESS")
                .version("v1")
                .build();
        resourceData = new ResourceData();
        resourceData.setData(listUser);
        return new ResponseEntity<>(getResponseData(metaData, resourceData), HttpStatus.OK);
    }


    private UserResponseModel getResponseData(MetaData metaData, ResourceData resourceData) {
        return UserResponseModel.builder()
                .metaData(metaData)
                .resourceData(resourceData)
                .build();
    }

    @RequestMapping(value = "/getUsersByIdMobileNumber", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserByIdAndMobileNumber(@RequestBody UserDto userdto) throws Exception {

        return new ResponseEntity<>(userManagementService.findByMobileIdNumberWithNative(userdto), HttpStatus.OK);
    }

}
