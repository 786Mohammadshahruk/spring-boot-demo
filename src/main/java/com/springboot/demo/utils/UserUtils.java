package com.springboot.demo.utils;

import com.springboot.demo.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    public static List<User> list = new ArrayList<>();

    public static List<User> getAllTheUser() {

        list.add(new User(1, "Aman", "kumar", "Mumbai", "abc@gmail.com", "9765555555",null,new BigDecimal(0.0)));
        list.add(new User(2, "Ajay", "kumar", "HYD", "abc@gmail.com", "9765555555",null,new BigDecimal(0.0)));
        list.add(new User(3, "Mohit", "kumar", "BLR", "abc@gmail.com", "9765555555",null,new BigDecimal(0.0)));
        list.add(new User(4, "hdhdh", "kumar", "Jharkhand", "abc@gmail.com", "9765555555",null,new BigDecimal(0.0)));
        list.add(new User(5, "kjdhdhd", "kumar", "Bihar", "abc@gmail.com", "9765555555",null,new BigDecimal(0.0)));
        list.add(new User(6, "yeteg", "kumar", "Delhi", "abc@gmail.com", "9765555555",null,new BigDecimal(0.0)));
        return list;
    }

    public static List<User> addUser(final User user) {
        list.add(user);
        return list;
    }
}
