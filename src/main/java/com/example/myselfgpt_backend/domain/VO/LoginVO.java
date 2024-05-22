package com.example.myselfgpt_backend.domain.VO;

import lombok.Data;

/**
 * @Description 登录接口，前往向后端传入的视图层对象（View Object）
 */
@Data
public class LoginVO {
    private String username;
    private String password;
}
