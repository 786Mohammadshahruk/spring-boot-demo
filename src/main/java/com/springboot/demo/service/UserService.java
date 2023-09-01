package com.springboot.demo.service;

import com.springboot.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getListOfUser();

    User getUserDetailsBasedOnId(long userId);
    List<User> createUser(User user) throws Exception;

    User getUserDetailsBasedOnName(String name);
}
