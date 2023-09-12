package com.springboot.demo.dtos;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String address;
    private String contactNumber;
}
