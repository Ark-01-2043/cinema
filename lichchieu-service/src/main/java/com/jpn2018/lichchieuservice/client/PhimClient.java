package com.jpn2018.lichchieuservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpn2018.lichchieuservice.dto.Phim;



@FeignClient(name = "phim-service", url = "${application.config.phims-url}")
public interface PhimClient {
	@GetMapping("/{id}")
    Phim getPhimById(@PathVariable("id") Long phimId);
}