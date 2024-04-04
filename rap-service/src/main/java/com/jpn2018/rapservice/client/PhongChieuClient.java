package com.jpn2018.rapservice.client;

import com.jpn2018.rapservice.entity.PhongChieu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "phongchieu-service", url = "${application.config.phongchieus-url}")
public interface PhongChieuClient {

    @GetMapping("/rap/{rap-id}")
    List<PhongChieu> findAllPhongchieusByRap(@PathVariable("rap-id") Long rapId);
}
