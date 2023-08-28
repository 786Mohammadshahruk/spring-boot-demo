package com.springboot.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String name;
    private String address;
    private int empId;
}
