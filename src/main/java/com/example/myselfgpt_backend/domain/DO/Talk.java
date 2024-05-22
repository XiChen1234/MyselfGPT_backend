package com.example.myselfgpt_backend.domain.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description Talk数据对象（Data Object），与数据库一一对应
 */
@Data
@TableName("talk")
public class Talk {
    @TableId("talk_id")
    private String id;
    @TableField("user_id")
    private String userId;
    private String title;
    @TableField("talk_index")
    private Integer talkIndex;
}
