package com.springboot.demo.service.impl;

import com.springboot.demo.dao.UserRepository;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return  user.get();
        }
        return null;
    }
}
