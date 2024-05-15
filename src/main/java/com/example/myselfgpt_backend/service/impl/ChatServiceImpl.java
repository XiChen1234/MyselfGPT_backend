package com.example.myselfgpt_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.myselfgpt_backend.domain.DTO.MessageDTO;
import com.example.myselfgpt_backend.domain.DTO.MessageListDTO;
import com.example.myselfgpt_backend.domain.Message;
import com.example.myselfgpt_backend.domain.Talk;
import com.example.myselfgpt_backend.mapper.MessageListMapper;
import com.example.myselfgpt_backend.mapper.MessageMapper;
import com.example.myselfgpt_backend.service.ChatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 聊天相关业务的具体实现
 */
@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private MessageListMapper messageListMapper;

    /**
     * 获取talk列表
     * @param userId 所属用户的id
     * @return talk列表
     */
    @Override
    public List<Talk> getTalkList(String userId) {
        QueryWrapper<MessageListDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(MessageListDTO::getUserId, userId);
        List<MessageListDTO> list = messageListMapper.selectList(queryWrapper);

        List<Talk> talkList = new ArrayList<>();
        for (MessageListDTO messageListDTO : list) {
            String messageListId = messageListDTO.getId();
            QueryWrapper<MessageDTO> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.lambda().eq(MessageDTO::getMessageListId, messageListId);
            List<MessageDTO> list1 = messageMapper.selectList(queryWrapper1);

            List<Message> messageList = new ArrayList<>();
            for (MessageDTO messageDTO : list1) {
                Message message = new Message();
                message.setIndex(messageDTO.getMessageIndex());
                message.setRequest(messageDTO.getRequest());
                message.setResponse(messageDTO.getResponse());

                messageList.add(message);
            }
            Talk talk = new Talk();
            talk.setMessageListId(messageListId);
            talk.setUserId(userId);
            if(!messageList.isEmpty()) {
                talk.setTitle(messageList.get(0).getRequest());
                Collections.sort(messageList);
                talk.setMessageList(messageList);
            }
            talkList.add(talk);
        }
        return talkList;
    }


    /**
     * 创建新的talk
     * @param userId 所属用户的id
     * @return 影响行数
     */
    @Override
    public Integer createNewTalk(String userId) {
        MessageListDTO messageList = new MessageListDTO();
        messageList.setUserId(userId);
        return messageListMapper.insert(messageList);
    }
}
