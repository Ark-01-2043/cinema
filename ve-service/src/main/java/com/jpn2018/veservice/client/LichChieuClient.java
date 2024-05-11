package com.jpn2018.veservice.client;

import com.jpn2018.veservice.dto.LichChieuDto;
import com.jpn2018.veservice.dto.LichChieuFullResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "lichchieu-service", url = "${application.config.lichchieus-url}")
public interface LichChieuClient {

    @GetMapping("/dtos/{id}")
    public ResponseEntity<LichChieuDto> getLichChieuDtoById(@PathVariable Long id);

    @GetMapping("/{id}/full")
    public LichChieuFullResponse getLichChieuFullResponseById(@PathVariable Long id);
}