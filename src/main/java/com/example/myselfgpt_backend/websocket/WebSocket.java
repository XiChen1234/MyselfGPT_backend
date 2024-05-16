package com.example.myselfgpt_backend.websocket;


import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * @Description 聊天websocket连接
 */

@ServerEndpoint(value = "/websocket/{userId}")
@Component
public class WebSocket {
    @OnOpen
    public void onOpen(@PathParam("userId") String userId) {
        System.out.printf("【websocket连接】%s用户建立连接%n", userId);
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.printf("【websocket消息】用户发送来消息：%s%n", message);
    }

    @OnClose
    public void OnClose(@PathParam("userId") String userId) {
        System.out.printf("【websocket断开】%s用户断开连接%n", userId);
    }

}
