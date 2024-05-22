package com.example.myselfgpt_backend.domain.VO;

import lombok.Data;

import java.util.List;

/**
 * @Description 获取会话列表接口
 * 前端向后端传入的视图层对象（View Object）
 */
@Data
public class TalkVO {
    private Integer index;
    private String title;
    private List<MessageVO> messageList;
}
