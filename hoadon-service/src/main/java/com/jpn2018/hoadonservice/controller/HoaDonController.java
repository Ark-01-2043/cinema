package com.jpn2018.hoadonservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jpn2018.hoadonservice.dto.DatVeRequest;
import com.jpn2018.hoadonservice.dto.HoaDonDto;
import com.jpn2018.hoadonservice.entity.HoaDon;
import com.jpn2018.hoadonservice.exception.ThanhVienNotFoundException;
import com.jpn2018.hoadonservice.service.HoaDonService;

import java.util.List;

@RestController
@RequestMapping("/api/hoadons")
@CrossOrigin(origins = "http://localhost:3000")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @PostMapping
    public HoaDon createHoaDon(@RequestBody HoaDon hoaDon) {
        return hoaDonService.saveHoaDon(hoaDon);
    }

    @GetMapping
    public List<HoaDon> getAllHoaDons() {
        return hoaDonService.getAllHoaDons();
    }

    @GetMapping("/{id}")
    public HoaDon getHoaDonById(@PathVariable Long id) {
        return hoaDonService.getHoaDonById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteHoaDon(@PathVariable Long id) {
        hoaDonService.deleteHoaDonById(id);
        return "Deleted HoaDon with ID: " + id;
    }

    @PutMapping("/{id}")
    public HoaDon updateHoaDon(@PathVariable Long id, @RequestBody HoaDon hoaDon) {
        return hoaDonService.updateHoaDon(id, hoaDon);
    }
    @PostMapping("/datve")
    public HoaDonDto datVe(@RequestBody HoaDon hoaDon) throws ThanhVienNotFoundException {
        return hoaDonService.datVe(hoaDon);
    }
}