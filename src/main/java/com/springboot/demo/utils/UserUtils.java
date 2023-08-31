package com.springboot.demo.utils;

import com.springboot.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {

    public static List<User> list = new ArrayList<>();

    public static List<User> getAllTheUser() {

        list.add(new User(1, "Aman", "kumar", "Mumbai"));
        list.add(new User(2, "Ajay", "kumar", "HYD"));
        list.add(new User(3, "Mohit", "kumar", "BLR"));
        list.add(new User(4, "hdhdh", "kumar", "Jharkhand"));
        list.add(new User(5, "kjdhdhd", "kumar", "Bihar"));
        list.add(new User(6, "yeteg", "kumar", "Delhi"));
        return list;
    }

    public static  List<User> addUser(final User user) {
        list.add(user);
        return list;
    }
}
