package com.example.myselfgpt_backend.domain.VO;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @Description 获取会话列表接口
 * 前端向后端传入的视图层对象（View Object）
 */
@Data
public class TalkVO implements Comparable<TalkVO>{
    private Integer index;
    private String title;
    private List<MessageVO> messageList;

    @Override
    public int compareTo(@NotNull TalkVO talk) {
        return Integer.compare(this.index, talk.index);
    }
}
