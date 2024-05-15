package com.example.myselfgpt_backend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @Description 会话类
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Talk {
    private String messageListId;
    private String userId;
    private String title;
    private List<Message> messageList;
}
