package com.example.myselfgpt_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.DO.Message;
import com.example.myselfgpt_backend.domain.DO.Talk;
import com.example.myselfgpt_backend.domain.DTO.MessageDTO;
import com.example.myselfgpt_backend.mapper.MessageMapper;
import com.example.myselfgpt_backend.mapper.TalkMapper;
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
    @Resource
    private TalkMapper talkMapper;

    /**
     * 保存一条消息
     *
     * @param talkIndex    talk的index
     * @param request      用户询问的问题
     * @param messageIndex message在列表中的索引
     * @return 保存结果
     */
    @Override
    public CommonResponse<Boolean> saveMessage(Integer talkIndex, String request, Integer messageIndex) {
        // 获取talk的id
        QueryWrapper<Talk> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Talk::getTalkIndex, talkIndex);
        Talk talk = talkMapper.selectOne(queryWrapper);
        String talkId = talk.getId();

        // 保存message
        Message message = new Message();
        message.setTalkId(talkId);
        message.setRequest(request);
        message.setResponse(""); // 默认为空
        message.setMessageIndex(messageIndex);
        int i = messageMapper.insert(message);
        if(i != 1) {
            return CommonResponse.creatForError();
        }
        return CommonResponse.creatForSuccessData(true);
    }
}
