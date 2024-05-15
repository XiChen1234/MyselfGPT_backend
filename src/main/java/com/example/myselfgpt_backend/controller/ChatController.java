package com.example.myselfgpt_backend.controller;

import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.Talk;
import com.example.myselfgpt_backend.domain.User;
import com.example.myselfgpt_backend.service.ChatService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 聊天相关接口
 */
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Resource
    private ChatService chatService;
    /**
     * 获取talk列表
     * @param userId 所属用户的id
     * @return talk列表
     */
    @GetMapping("/talk")
    public CommonResponse<List<Talk>> getTalkList(@RequestParam String userId) {
        return CommonResponse.creatForSuccessData(chatService.getTalkList(userId));
    }
    /**
     * 创建新的talk
     * @param user 所属用户的id
     * @return 是否创建成功
     */
    @PostMapping("/talk")
    public CommonResponse<Boolean> creatTalk(@RequestBody User user) {
        String userId = user.getUserId();
        int res = chatService.createNewTalk(userId);
        if(res != 0) {
            return CommonResponse.creatForSuccessData(true);
        }

        return CommonResponse.creatForErrorMessage("创建失败");
    }
}
