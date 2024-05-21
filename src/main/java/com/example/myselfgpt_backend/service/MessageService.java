package com.example.myselfgpt_backend.service;

/**
 * @Description message相关业务层接口
 */
public interface MessageService {
    /**
     * 保存一条消息
     * @param messageListId messageList的id
     * @param request 用户询问的问题
     * @param messageIndex message在列表中的索引
     * @return 影响行数是否等于1（是否成功）
     */
    public Boolean saveMessage(String messageListId,
                            String request,
                            int messageIndex);
}
