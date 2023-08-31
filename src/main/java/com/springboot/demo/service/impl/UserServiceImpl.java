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

    @Override
    public List<User> createUser(User user) throws Exception {
        if (user.getId() <= 0) {
            throw new Exception("Invalid User");
        }
        System.out.println("Inside Service ");
        return userDao.createUser(user);
    }
}
