package com.jpn2018.doidiemservice.client;


import com.jpn2018.doidiemservice.entity.DichVu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dichvu-service", url = "${application.config.dichvus-url}")
public interface DichVuClient {

    @GetMapping("/{id}")
    DichVu getDichVuById(@PathVariable("id") Long dichVuId);
}