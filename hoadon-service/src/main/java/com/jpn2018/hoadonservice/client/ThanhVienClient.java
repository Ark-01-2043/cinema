package com.jpn2018.hoadonservice.client;

import com.jpn2018.hoadonservice.dto.ThanhVien;
import com.jpn2018.hoadonservice.exception.ThanhVienNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(url = "${application.config.thanhviens-url}", name = "thanhvien-service")
public interface ThanhVienClient {
    @GetMapping("/id/{id}")
    public ThanhVien getThanhVienById(@PathVariable Long id);

    @GetMapping
    public List<ThanhVien> getAllThanhViens();

    @GetMapping("/{email}")
    public ThanhVien getThanhVienByEmail(@PathVariable String email) throws ThanhVienNotFoundException;
}
