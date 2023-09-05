package com.springboot.demo.service;

import com.springboot.demo.entity.User;

import java.util.List;

public interface UserManagementService {

    public User createUser(User user);

    public List<User> findAll();

    public User findById(long id);
}
