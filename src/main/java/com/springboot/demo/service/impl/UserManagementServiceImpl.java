package com.springboot.demo.service.impl;

import com.springboot.demo.dao.UserRepository;
import com.springboot.demo.dtos.UserDto;
import com.springboot.demo.entity.User;
import com.springboot.demo.exception.CustomException;
import com.springboot.demo.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        User savedUser = userRepository.save(user);
        if (Objects.isNull(savedUser)) {
            throw new CustomException("User is Null !!!");
        }
        return savedUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User updateUser(long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "User Deleted";
    }

    @Override
    public String deleteAllUser() {

        userRepository.deleteAll();
        return "All User Deleted";
    }

    @Override
    public String deleteUserEntity(User user) {
        userRepository.delete(user);
        return "User Is Deleted";
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByFirstName(name);
    }

    @Override
    public List<User> findByPrice(BigDecimal price) {
        return userRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<User> findByMobileNumberWithJPQL(String mobileNumber) {
        return userRepository.findByMobileNumber(mobileNumber);
    }

    @Override
    public List<User> findByMobileNumberWithNative(String mobileNumber) {
        return userRepository.getByMobileNumber(mobileNumber);
    }

    @Override
    public List<User> findByMobileIdNumberWithNative(UserDto userdto) {
        return userRepository.findByMobileIdNumberWithNative(userdto.getId(),
                userdto.getContactNumber(), userdto.getAddress());
    }

}
