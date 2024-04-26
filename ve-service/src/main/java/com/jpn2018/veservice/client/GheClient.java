package com.jpn2018.veservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpn2018.veservice.dto.Ghe;



@FeignClient(name = "ghe-service", url = "${application.config.ghes-url}")
public interface GheClient {
	@GetMapping("/{id}")
    public Ghe getGheById(@PathVariable("id") Long gheId);
}
