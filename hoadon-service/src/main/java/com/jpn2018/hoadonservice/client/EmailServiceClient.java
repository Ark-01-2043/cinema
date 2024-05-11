package com.jpn2018.hoadonservice.client;

import com.jpn2018.hoadonservice.dto.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-service", url = "${application.config.emailservice-url}")
public interface EmailServiceClient {

    @PostMapping("/sendEmail")
    void sendEmail(@RequestBody EmailRequest emailRequest);
}
