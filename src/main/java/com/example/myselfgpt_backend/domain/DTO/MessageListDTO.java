package com.example.myselfgpt_backend.domain.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description 消息列表类，对应数据库Message List
 */
@TableName("message_list")
@Data
public class MessageListDTO {
    @TableId("message_list_id")
    private String id;
    @TableField("user_id")
    private String userId;
}
