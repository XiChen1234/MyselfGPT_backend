package com.example.myselfgpt_backend.service;

import com.example.myselfgpt_backend.domain.VO.Talk;

import java.util.List;

/**
 * @Description 聊天相关业务层接口
 */
public interface ChatService {
    /**
     * 获取talk列表
     * @param userId 所属用户的id
     * @return talk列表
     */
    public List<Talk> getTalkList(String userId);

    /**
     * 创建新的talk
     * @param userId 所属用户的id
     * @return 影响行数
     */
    public Integer createNewTalk(String userId);
}
