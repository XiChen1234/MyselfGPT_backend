package com.example.myselfgpt_backend.domain.VO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description 用户PO类 对应数据库表
 */
@TableName("user")
@Data
public class User {
    @TableId("user_id")
    private String userId;
    private String username;
    private String password;
}
