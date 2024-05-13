package com.example.myselfgpt_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.User;
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
    public CommonResponse<Boolean> login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, username).eq(User::getPassword, password);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null) {
            return CommonResponse.creatForWarningMessage("用户名或密码错误");
        }
        // 登录成功
        return CommonResponse.creatForSuccessData(true);
    }
}
