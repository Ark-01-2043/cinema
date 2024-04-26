package com.jpn2018.lichchieuservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpn2018.lichchieuservice.dto.PhongChieu;



@FeignClient(name = "phongchieu-service", url = "${application.config.phongchieus-url}")
public interface PhongChieuClient {
	@GetMapping("/{id}")
    public PhongChieu getPhongChieuById(@PathVariable Long id);
}
