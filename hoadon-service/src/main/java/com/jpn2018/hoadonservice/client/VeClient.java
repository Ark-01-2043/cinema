package com.jpn2018.hoadonservice.client;

import com.jpn2018.hoadonservice.dto.Ve;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(url = "${application.config.ves-url}", name = "ve-service")
public interface VeClient {
    @GetMapping
    public List<Ve> getAllVes();

    @GetMapping("/{id}")
    public Ve getVeById(@PathVariable Long id);

    @PutMapping("/{id}")
    public Ve updateVe(@PathVariable Long id, @RequestBody Ve ve);

}
