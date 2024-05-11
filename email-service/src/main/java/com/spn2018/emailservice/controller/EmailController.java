package com.spn2018.emailservice.controller;

import com.spn2018.emailservice.entity.EmailRequest;
import com.spn2018.emailservice.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        String toEmail = emailRequest.getToEmail();
        String subject = emailRequest.getSubject();
        String body = emailRequest.getBody();

        emailSenderService.sendSimpleEmail(toEmail, subject, body);
    }
}
