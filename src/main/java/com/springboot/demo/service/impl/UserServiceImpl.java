package com.springboot.demo.service.impl;

import com.springboot.demo.dao.UserDao;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getListOfUser() {
        return userDao.getUserDetails();
    }

    @Override
    public User getUserDetailsBasedOnId(long userId) {
        return userDao.getUserDetailsBasedOnId(userId);
    }
}
