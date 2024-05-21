package com.example.myselfgpt_backend.domain.VO;

import lombok.Data;

/**
 * @Description 消息逻辑类
 */
@Data
public class Message implements Comparable<Message> {
    private int index;
    private String request;
    private String response;
    private String messageListId;


    @Override
    public int compareTo(Message message) {
        return Integer.compare(this.index, message.index);
    }
}
