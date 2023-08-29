package com.springboot.demo.service;

import com.springboot.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getListOfUser();

    User getUserDetailsBasedOnId(long userId);
}
