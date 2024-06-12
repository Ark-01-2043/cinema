package com.jpn2018.progressservice.service;

import com.jpn2018.progressservice.entity.Progress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    public void sendProgress(String method, int statusCode, String content, int percentage) {
        method = method.split(",")[0];
        content = content.split(",")[0];

        var chatMessage = Progress.builder()
                .method(method)
                .statusCode(statusCode)
                .content(content)
                .percentage(percentage)
                .build();
        System.out.println(chatMessage);
        messagingTemplate.convertAndSend("/topic/messages", chatMessage);
    }
}
