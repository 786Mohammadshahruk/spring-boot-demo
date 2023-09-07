package com.springboot.demo.service;

import com.springboot.demo.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserManagementService {

    public User createUser(User user);

    public List<User> findAll();

    public User findById(long id);

    User updateUser(long id, User user);

    String deleteUser(long id);

    String deleteAllUser();

    String deleteUserEntity(User user);

    public List<User> findByName(String name);

    public List<User> findByPrice(BigDecimal price);

    public List<User> findByMobileNumberWithJPQL(String mobileNumber);

    public List<User> findByMobileNumberWithNative(String mobileNumber);
}
