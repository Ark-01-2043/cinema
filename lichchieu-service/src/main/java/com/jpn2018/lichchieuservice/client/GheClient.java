package com.jpn2018.lichchieuservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpn2018.lichchieuservice.dto.Ghe;



@FeignClient(name = "ghe-service", url = "${application.config.ghes-url}")
public interface GheClient {
	@GetMapping("/{id}")
    public Ghe getGheById(@PathVariable Long gheId);
}
