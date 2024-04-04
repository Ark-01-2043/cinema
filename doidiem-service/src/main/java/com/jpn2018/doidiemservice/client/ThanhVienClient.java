package com.jpn2018.doidiemservice.client;


import com.jpn2018.doidiemservice.entity.ThanhVien;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "thanhvien-service", url = "${application.config.thanhviens-url}")
public interface ThanhVienClient {

    @GetMapping("/{id}")
    ThanhVien getThanhVienById(@PathVariable("id") Long thanhVienId);
}