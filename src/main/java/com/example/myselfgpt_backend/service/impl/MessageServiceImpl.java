package com.example.myselfgpt_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.DO.Message;
import com.example.myselfgpt_backend.domain.DO.Talk;
import com.example.myselfgpt_backend.mapper.MessageMapper;
import com.example.myselfgpt_backend.mapper.TalkMapper;
import com.example.myselfgpt_backend.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

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

        if(Objects.equals(talk.getTitle(), "新对话")) {
            talk.setTitle(request);
            talkMapper.updateById(talk);
        }

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

    /**
     * 更新大模型回答之后的问题
     * @param userId 用户id
     * @param talkIndex 会话index
     * @param response 大模型给出的回复
     * @return 响应结果
     */
    @Override
    public CommonResponse<Boolean> updateMessage(String userId, Integer talkIndex, String response) {
        QueryWrapper<Talk> talkQueryWrapper =new QueryWrapper<>();
        talkQueryWrapper.lambda().eq(Talk::getUserId, userId).eq(Talk::getTalkIndex, talkIndex);
        Talk talk = talkMapper.selectOne(talkQueryWrapper);
        String talkId = talk.getId();

        QueryWrapper<Message> messageQueryWrapper = new QueryWrapper<>();
        messageQueryWrapper.lambda().eq(Message::getTalkId, talkId).eq(Message::getResponse, "");
        Message message = messageMapper.selectOne(messageQueryWrapper);
        message.setResponse(response);
        int i = messageMapper.updateById(message);
        System.out.println(i);
        if(i != 1) {
            return CommonResponse.creatForError();
        }

        return CommonResponse.creatForSuccessData(true);
    }
}
