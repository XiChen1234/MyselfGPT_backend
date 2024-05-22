package com.example.myselfgpt_backend.service;

import com.example.myselfgpt_backend.common.CommonResponse;

/**
 * @Description message相关业务层接口
 */
public interface MessageService {
    /**
     * 保存一条消息
     *
     * @param talkIndex    talk的index
     * @param request      用户询问的问题
     * @param messageIndex message在列表中的索引
     * @return 保存结果
     */
    public CommonResponse<Boolean> saveMessage(Integer talkIndex,
                                               String request,
                                               Integer messageIndex);
}
