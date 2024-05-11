package com.jpn2018.lichchieuservice.client;

import com.jpn2018.lichchieuservice.dto.Rap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rap-service", url = "${application.config.raps-url}")
public interface RapClient {

    @GetMapping("/{id}")
    public Rap getRapById(@PathVariable("id") Long rapId);

}
