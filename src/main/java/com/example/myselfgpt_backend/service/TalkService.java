package com.example.myselfgpt_backend.service;

import com.example.myselfgpt_backend.common.CommonResponse;
import com.example.myselfgpt_backend.domain.VO.TalkVO;

import java.util.List;

/**
 * @Description 聊天界面相关业务层接口
 */
public interface TalkService {
    /**
     * 获取talk列表
     * @param userId 用户id
     * @return 响应结果
     */
    public CommonResponse<List<TalkVO>> getTalkList(String userId);
}
