package com.jpn2018.lichchieuservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpn2018.lichchieuservice.dto.KhungGio;



@FeignClient(name = "khunggio-service", url = "${application.config.khunggios-url}")
public interface KhungGioClient {
	@GetMapping("/{id}")
    public KhungGio getKhungGioById(@PathVariable Long id);
}
