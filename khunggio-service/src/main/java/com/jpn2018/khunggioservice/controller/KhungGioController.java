package com.jpn2018.khunggioservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jpn2018.khunggioservice.entity.KhungGio;
import com.jpn2018.khunggioservice.service.KhungGioService;

import java.util.List;

@RestController
@RequestMapping("/api/khunggios")
public class KhungGioController {

    @Autowired
    private KhungGioService khungGioService;

    @PostMapping
    public KhungGio createKhungGio(@RequestBody KhungGio khungGio) {
        return khungGioService.saveKhungGio(khungGio);
    }

    @GetMapping
    public List<KhungGio> getAllKhungGios() {
        return khungGioService.getAllKhungGios();
    }

    @GetMapping("/{id}")
    public KhungGio getKhungGioById(@PathVariable Long id) {
        return khungGioService.getKhungGioById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteKhungGio(@PathVariable Long id) {
        khungGioService.deleteKhungGioById(id);
        return "Deleted KhungGio with ID: " + id;
    }

    @PutMapping("/{id}")
    public KhungGio updateKhungGio(@PathVariable Long id, @RequestBody KhungGio khungGio) {
        return khungGioService.updateKhungGio(id, khungGio);
    }
}
