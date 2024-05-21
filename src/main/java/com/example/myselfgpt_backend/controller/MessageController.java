package com.example.myselfgpt_backend.controller;

import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.VO.Message;
import com.example.myselfgpt_backend.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 */
@RestController
@RequestMapping("/api")
public class MessageController {
    @Resource
    private MessageService messageService;

    /**
     * 保存一条新消息
     * @param message 消息内容
     * @return 响应结果
     */
    @PostMapping("/message")
    public CommonResponse<Boolean> saveMessage(@RequestBody Message message) {
        return CommonResponse.creatForSuccessData(
                messageService.saveMessage(message.getMessageListId(),
                        message.getRequest(),
                        message.getIndex())
        );
    }
}
