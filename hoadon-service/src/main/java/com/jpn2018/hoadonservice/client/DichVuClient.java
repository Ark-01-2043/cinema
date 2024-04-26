package com.jpn2018.hoadonservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpn2018.hoadonservice.dto.DichVu;



@FeignClient(url = "${application.config.dichvus-url}", name = "dichvu-service")
public interface DichVuClient {
	@GetMapping
    public List<DichVu> getAllDichVus();
	@GetMapping("/{id}")
    public DichVu getDichVuById(@PathVariable Long id);
	@PutMapping("/{id}")
    public DichVu updateDichVu(@PathVariable Long id, @RequestBody DichVu dichVu);
}
