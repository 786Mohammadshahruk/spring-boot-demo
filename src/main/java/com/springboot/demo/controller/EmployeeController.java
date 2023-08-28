package com.springboot.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
    public String addTheEmployee( @RequestBody Employee employee) {
        System.out.println(employee);
        return "Employee Id Added ";
    }

}
