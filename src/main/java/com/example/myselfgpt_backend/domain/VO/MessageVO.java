package com.example.myselfgpt_backend.domain.VO;

import lombok.Data;

/**
 * @Description 获取会话列表接口，用到的Message对象
 * 前端向后端传入的视图层对象（View Object）
 */
@Data
public class MessageVO {
    private Integer index;
    private String answer;
    private String question;
}
