package com.springboot.demo.dao.impl;

import com.springboot.demo.dao.UserDao;
import com.springboot.demo.entity.User;
import com.springboot.demo.utils.UserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getUserDetails() {
        return UserUtils.getAllTheUser();
    }

    @Override
    public User getUserDetailsBasedOnId(long userId) {
        List<User> userList = UserUtils.getAllTheUser();
        for (User user : userList) {
            if (userId == user.getId()) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> createUser(final User user) {
        System.out.println("Inside DAO ");
        return UserUtils.addUser(user);
    }
}
