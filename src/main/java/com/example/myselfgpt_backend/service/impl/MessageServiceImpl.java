package com.example.myselfgpt_backend.service.impl;

import com.example.myselfgpt_backend.domain.DTO.MessageDTO;
import com.example.myselfgpt_backend.mapper.MessageMapper;
import com.example.myselfgpt_backend.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description message相关业务的具体实现
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    /**
     * 保存一条新的消息
     *
     * @param messageListId messageList的id
     * @param request       用户询问的问题
     * @param messageIndex  message在列表中的索引
     * @return 影响行数是否等于1（是否成功）
     */
    @Override
    public Boolean saveMessage(String messageListId,
                               String request,
                               int messageIndex) {
        MessageDTO message = new MessageDTO();
        message.setMessageListId(messageListId);
        message.setRequest(request);
        message.setMessageIndex(messageIndex);
        message.setResponse("");
        return messageMapper.insert(message) == 1;
    }
}
