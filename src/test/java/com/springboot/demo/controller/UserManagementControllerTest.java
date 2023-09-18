package com.springboot.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserManagementService;
import com.springboot.demo.utils.ConstantTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.springboot.demo.utils.ConstantTest.convertObjectToString;
import static com.springboot.demo.utils.ConstantTest.getUser;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserManagementController.class)
public class UserManagementControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserManagementService userManagementService;


    private User user;

    @BeforeEach
    public void init() throws JsonProcessingException {
        user = ConstantTest.convertStringToObject(User.class, getUser());
    }

    @Test
    void createUserTest() throws Exception {
        when(userManagementService.createUser(any(User.class))).thenReturn(user);
        this.mockMvc.perform(post("/user-management/create").contentType("application/json")
                .content(convertObjectToString(user))).andExpect(status().isOk());

    }

    @Test
    void createUserAndValidateResponseOkTest() throws Exception {
        when(userManagementService.createUser(any(User.class))).thenReturn(user);
        MvcResult result = this.mockMvc.perform(post("/user-management/create").contentType("application/json")
                .content(convertObjectToString(user))).andExpect(status().isOk()).andReturn();
        assertNotNull(result);
        //verify(userManagementService, times(1)).createUser(any(User.class));
    }


}
