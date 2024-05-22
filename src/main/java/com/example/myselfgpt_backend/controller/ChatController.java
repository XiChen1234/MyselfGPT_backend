package com.example.myselfgpt_backend.controller;

import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.DO.User;
import com.example.myselfgpt_backend.domain.VO.MessageVO;
import com.example.myselfgpt_backend.domain.VO.TalkVO;
import com.example.myselfgpt_backend.service.MessageService;
import com.example.myselfgpt_backend.service.TalkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 在聊天界面使用到的非websocket的相关的API接口
 */
@RestController
@RequestMapping("api/talk")
public class ChatController {
    @Resource
    private TalkService talkService;
    @Resource
    private MessageService messageService;

    /**
     * 获取talk列表
     *
     * @param userId 所属用户的id
     * @return talk列表
     */
    @GetMapping
    public CommonResponse<List<TalkVO>> getTalkList(@RequestParam String userId) {
        return talkService.getTalkList(userId);
    }

    /**
     * 创建新的talk
     *
     * @param user 所属用户的id
     * @return 是否创建成功
     */
    @PostMapping
    public CommonResponse<Boolean> creatTalk(@RequestBody User user) {
        String userId = user.getId();
        return talkService.creatTalk(userId);
    }

    /**
     * 发送信息并将其保存到数据库中
     *
     * @param message 发送的信息对象
     * @return 响应结果
     */
    @PostMapping("/message")
    public CommonResponse<Boolean> creatMessage(@RequestBody MessageVO message) {
        Integer messageIndex = message.getIndex();
        String question = message.getQuestion();
        Integer talkIndex = message.getTalkIndex();
        return messageService.saveMessage(talkIndex, question, messageIndex);
    }

    @PutMapping("/message")
    public CommonResponse<Boolean> saveResponse(@RequestBody MessageVO message) {
        String userId = message.getUserId();
        Integer talkIndex = message.getTalkIndex();
        String response = message.getAnswer();

        return messageService.updateMessage(userId, talkIndex, response);
    }
}
