package com.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String address;
}
