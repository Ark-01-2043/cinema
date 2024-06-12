package com.jpn2018.lichchieuservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "progress-service", url = "${application.config.progress-url}")
public interface ProgressClient {

    @PostMapping("")
    public void sendProgress(@RequestParam String method, @RequestParam int statusCode, @RequestParam String content, @RequestParam int percentage);

}
