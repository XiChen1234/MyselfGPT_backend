package com.example.myselfgpt_backend.domain.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description Message数据对象（Data Object），与数据库一一对应
 */
@Data
@TableName("message")
public class Message {
    @TableId("message_id")
    private String id;
    @TableField("talk_id")
    private String talkId;
    private String request;
    private String response;
    @TableField("message_index")
    private Integer messageIndex;
}
