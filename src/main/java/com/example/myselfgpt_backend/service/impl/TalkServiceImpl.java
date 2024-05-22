package com.example.myselfgpt_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.DO.Message;
import com.example.myselfgpt_backend.domain.DO.Talk;
import com.example.myselfgpt_backend.domain.VO.MessageVO;
import com.example.myselfgpt_backend.domain.VO.TalkVO;
import com.example.myselfgpt_backend.mapper.MessageMapper;
import com.example.myselfgpt_backend.mapper.TalkMapper;
import com.example.myselfgpt_backend.service.TalkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 聊天界面相关业务具体实现
 */
@Service
public class TalkServiceImpl implements TalkService {
    @Resource
    private TalkMapper talkMapper;
    @Resource
    private MessageMapper messageMapper;
    /**
     * 获取talk列表
     * @param userId 用户id
     * @return 响应结果
     */
    @Override
    public CommonResponse<List<TalkVO>> getTalkList(String userId) {
        // 匹配userId下的talk
        QueryWrapper<Talk> talkQueryWrapper = new QueryWrapper<>();
        talkQueryWrapper.lambda().eq(Talk::getUserId, userId);
        List<Talk> talkList = talkMapper.selectList(talkQueryWrapper);

        List<TalkVO> talkVOS = new ArrayList<>(); // 存储结果
        for(Talk talkItem: talkList) {
            String talkId = talkItem.getId();

            // 匹配talkId下的message
            QueryWrapper<Message> messageQueryWrapper = new QueryWrapper<>();
            messageQueryWrapper.lambda().eq(Message::getTalkId, talkId);
            List<Message> messageList = messageMapper.selectList(messageQueryWrapper);

            List<MessageVO> messageVOS = new ArrayList<>(); // 存储结果
            for(Message messageItem : messageList) {
                MessageVO message = new MessageVO();
                message.setIndex(messageItem.getMessageIndex());
                message.setQuestion(messageItem.getRequest());
                message.setAnswer(messageItem.getResponse());

                messageVOS.add(message);
            }

            TalkVO talk = new TalkVO();
            talk.setIndex(talkItem.getTalkIndex());
            talk.setTitle(talkItem.getTitle());
            talk.setMessageList(messageVOS);

            talkVOS.add(talk);
        }

        return CommonResponse.creatForSuccessData(talkVOS);
    }
}
