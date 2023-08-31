package com.springboot.demo.dao;

import com.springboot.demo.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getUserDetails();

    User getUserDetailsBasedOnId(long userId);

    List<User> createUser(User user);
}
