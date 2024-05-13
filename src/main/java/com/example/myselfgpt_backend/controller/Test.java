package com.example.myselfgpt_backend.controller;

import com.example.myselfgpt_backend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 测试类
 */
@RestController
public class Test {
    @Resource
    private UserService userService;
    @GetMapping("/")
    public String hello() {
        return userService.getUsernameById(String.valueOf(1));
    }
}
