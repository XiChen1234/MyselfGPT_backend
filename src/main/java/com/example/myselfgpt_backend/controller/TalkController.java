package com.example.myselfgpt_backend.controller;

import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.VO.TalkVO;
import com.example.myselfgpt_backend.service.TalkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 在聊天界面使用到的非websocket的相关的API接口
 */
@RestController
@RequestMapping("api/talk")
public class TalkController {
    @Resource
    private TalkService talkService;
    @GetMapping
    public CommonResponse<List<TalkVO>> getTalkList(@RequestParam String userId) {
        System.out.println(userId);
        return talkService.getTalkList(userId);
    }
}
