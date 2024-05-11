package com.jpn2018.khunggioservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jpn2018.khunggioservice.entity.KhungGio;
import com.jpn2018.khunggioservice.service.KhungGioRedisService;
import com.jpn2018.khunggioservice.service.KhungGioService;

import java.util.List;

@RestController
@RequestMapping("/api/khunggios")
public class KhungGioController {

    @Autowired
    private KhungGioService khungGioService;
    @Autowired
    private KhungGioRedisService khungGioRedisService;
    @PostMapping
    public KhungGio createKhungGio(@RequestBody KhungGio khungGio) {
        return khungGioService.saveKhungGio(khungGio);
    }

    @GetMapping
    public List<KhungGio> getAllKhungGios() {
        return khungGioService.getAllKhungGios();
    }

    @GetMapping("/{id}")
    public KhungGio getKhungGioById(@PathVariable Long id) throws JsonProcessingException {
    	KhungGio khungGio = khungGioRedisService.getKhungGioById(id);
    	if (khungGio == null) {
			khungGio = khungGioService.getKhungGioById(id);
			khungGioRedisService.saveKhungGio(khungGio);
		}
        return khungGio;
    }

    @DeleteMapping("/{id}")
    public String deleteKhungGio(@PathVariable Long id) {
        khungGioService.deleteKhungGioById(id);
        khungGioRedisService.deleteKhungGio(id);
        return "Deleted KhungGio with ID: " + id;
    }

    @PutMapping("/{id}")
    public KhungGio updateKhungGio(@PathVariable Long id, @RequestBody KhungGio khungGio) throws JsonProcessingException {
        KhungGio newKhungGio = khungGioService.updateKhungGio(id, khungGio);
        khungGioRedisService.deleteKhungGio(id);
        khungGioRedisService.saveKhungGio(newKhungGio);
    	return newKhungGio;
    }
}
