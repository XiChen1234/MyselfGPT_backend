package com.example.myselfgpt_backend.domain.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description 消息类，对应数据库Message
 */
@TableName("message")
@Data
public class MessageDTO {
    @TableId("message_id")
    private String id;
    @TableField("message_list_id")
    private String messageListId;
    private String request;
    private String response;
    @TableField("i")
    private int messageIndex;
}
