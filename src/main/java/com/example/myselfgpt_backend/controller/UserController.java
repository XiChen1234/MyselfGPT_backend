package com.example.myselfgpt_backend.controller;

import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.VO.LoginVO;
import com.example.myselfgpt_backend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 账户相关API操作
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public CommonResponse<Boolean> login(@RequestBody LoginVO user) {
        String username = user.getUsername();
        String password = user.getPassword();
        // todo: 参数校验，暂时省略
        return userService.login(username, password);
    }
}
