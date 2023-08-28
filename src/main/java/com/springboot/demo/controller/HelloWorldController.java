package com.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/hello")
public class HelloWorldController {

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(@PathVariable("id") String id) {
        return id + "Hello World";
    }

    @GetMapping("/get1/{id}")
    @ResponseBody
    public String helloWorld1(@PathVariable("id") String id) {
        return "Hello World 1";
    }

    @GetMapping("/get2")
    @ResponseBody
    public String helloWorld2() {
        return "Hello World 2";
    }
}
