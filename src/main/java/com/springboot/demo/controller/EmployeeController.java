package com.springboot.demo.controller;

import com.springboot.demo.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
    public String addTheEmployee( @RequestBody Employee employee) {
        System.out.println(employee);
        return "Employee Id Added ";
    }

}
