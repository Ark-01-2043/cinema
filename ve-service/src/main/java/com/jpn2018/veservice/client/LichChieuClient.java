package com.jpn2018.veservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.jpn2018.veservice.dto.*;


@FeignClient(name = "lichchieu-service", url = "${application.config.lichchieus-url}")
public interface LichChieuClient {
	
	@GetMapping("/dtos/{id}")
    public ResponseEntity<LichChieuDto> getLichChieuDtoById(@PathVariable Long id);
}