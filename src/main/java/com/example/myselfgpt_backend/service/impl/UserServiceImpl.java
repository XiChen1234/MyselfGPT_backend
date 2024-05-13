package com.example.myselfgpt_backend.service.impl;

import com.example.myselfgpt_backend.mapper.UserMapper;
import com.example.myselfgpt_backend.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 用户相关业务的具体实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public String getUsernameById(String userId) {
        return userMapper.selectById(userId).getUsername();
    }
}
