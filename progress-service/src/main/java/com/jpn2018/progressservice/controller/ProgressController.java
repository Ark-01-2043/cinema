package com.jpn2018.progressservice.controller;

import com.jpn2018.progressservice.service.ProgressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ProgressController {

//    @Autowired
//    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    private ProgressService progressService;

    @PostMapping
    public void sendProgress(@RequestParam String method, @RequestParam int statusCode, @RequestParam String content, @RequestParam int percentage) {
        log.info("send message: " + method + " " + statusCode + " " + content + " " + percentage);
        progressService.sendProgress(method, statusCode, content, percentage);
    }
}
