package com.springboot.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.demo.entity.User;
import com.springboot.demo.model.response.UserResponseModel;
import com.springboot.demo.service.UserManagementService;
import com.springboot.demo.utils.ConstantTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.springboot.demo.utils.ConstantTest.getUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserManagementControllerV2Test {

    @InjectMocks
    UserManagementController userManagementController;

    @Mock
    UserManagementService userManagementService;


    private User user;

    @BeforeEach
    public void init() throws JsonProcessingException {
        user = ConstantTest.convertStringToObject(User.class, getUser());
    }

    @Test
    void createUserTest() throws Exception {
        when(userManagementService.createUser(any(User.class))).thenReturn(user);
        ResponseEntity<UserResponseModel> responseEntity = userManagementController.createUser(user);
        UserResponseModel userResponseModel = responseEntity.getBody();
        User resultUser = (User)userResponseModel.getResourceData().getData();
        assertEquals(200,responseEntity.getStatusCode().value());
        assertEquals("Ajay",resultUser.getFirstName());
    }

}
