package com.example.myselfgpt_backend.websocket;

import com.example.myselfgpt_backend.service.MessageService;
import com.example.myselfgpt_backend.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.example.myselfgpt_backend.websocket.BigModelNew.*;

/**
 * @Description websocket接口
 * 访问/api/websocket/{userId}即建立websocket连接，后续在这里进行信息收发工作
 * 这个是多例的
 */
@ServerEndpoint(value = "/api/websocket/{userId}")
@Component
public class WebSocket {
    private String userId;
    private static final Map<String, Session> userMap = new ConcurrentHashMap<>();

    /**
     * 保存Message
     * @param userId 用户id
     * @param totalAnswer gpt给予的最终所有的答复
     */
    public static void saveMessage(String userId, String totalAnswer) {
    }


    /**
     * 建立连接后触发的方法
     *
     * @param session session对象，对应用户
     * @param userId  用户id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        System.out.printf("【websocket连接】用户%s建立连接%n", userId);
        this.userId = userId;
        userMap.put(userId, session);
    }

    /**
     * 客户端向服务端发送消息后触发的方法
     *
     * @param message 具体消息，消息内部存储用户id
     *                json字符串，解析如下：
     *                {
     *                  index: {number} message的索引,
     *                  messageList: {string} messageList的id,
     *                  request: {string} 用户发的问题
     *                }
     */
    @OnMessage
    public void onMessage(String message) throws Exception {
        System.out.printf("【websocket消息】用户%s发送来消息：%s%n", this.userId, message);
        // 访问讯飞星火服务器的websocket，收到的消息向用户进行展示
        // 构建鉴权url
//        NewQuestion=message;
//        String authUrl = getAuthUrl(hostUrl, apiKey, apiSecret);
//        OkHttpClient client = new OkHttpClient.Builder().build();
//        String url = authUrl.replace("http://", "ws://").replace("https://", "wss://");
//        Request request = new Request.Builder().url(url).build();
//        totalAnswer = "";
//        okhttp3.WebSocket webSocket = client.newWebSocket(request, new BigModelNew(userId, false));
    }

    /**
     * 断开连接时触发的方法
     *
     * @param userId 用户id
     */
    @OnClose
    public void OnClose(@PathParam("userId") String userId) {
        System.out.printf("【websocket断开】用户%s断开连接%n", userId);
        userMap.remove(userId);
    }

    /**
     * 服务端主动向客户端发送消息
     *
     * @param userId  客户端用户id
     * @param message 消息内容
     */
    public static void sendMessage(String userId, String message) {
        Session session = userMap.get(userId);
        session.getAsyncRemote().sendText(message);
    }
}
