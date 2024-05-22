package com.example.myselfgpt_backend.domain.DO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description User数据对象（Data Object），与数据库一一对应
 */
@Data
@TableName("user")
public class User {
    @TableId("user_id")
    private String id;
    private String username;
    private String password;
}
