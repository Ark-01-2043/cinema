package com.jpn2018.hoadonservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jpn2018.hoadonservice.dto.Ve;
import com.jpn2018.hoadonservice.dto.VeDto;




@FeignClient(url = "${application.config.ves-url}", name = "ve-service")
public interface VeClient {
	@GetMapping
    public List<Ve> getAllVes();

    @GetMapping("/{id}")
    public Ve getVeById(@PathVariable Long id);
    @PatchMapping("/{id}")
    public Ve changeStatus(@PathVariable Long id);
}
