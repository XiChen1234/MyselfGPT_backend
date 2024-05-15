package com.example.myselfgpt_backend.domain;

import lombok.Data;

/**
 * @Description 消息逻辑类
 */
@Data
public class Message implements Comparable<Message> {
    private int index;
    private String request;
    private String response;


    @Override
    public int compareTo(Message message) {
        return Integer.compare(this.index, message.index);
    }
}
