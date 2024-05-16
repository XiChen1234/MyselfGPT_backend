package com.example.myselfgpt_backend.service;


import com.example.myselfgpt_backend.common.CommonResponse;

/**
 * @Description 用户相关业务层接口
 */
public interface UserService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 是否登录成功
     */
    public CommonResponse<Boolean> login(String username, String password);
}
