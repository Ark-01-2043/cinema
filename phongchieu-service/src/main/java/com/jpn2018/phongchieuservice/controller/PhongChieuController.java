package com.jpn2018.phongchieuservice.controller;

import com.jpn2018.phongchieuservice.entity.PhongChieu;
import com.jpn2018.phongchieuservice.service.PhongChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phongchieus")
public class PhongChieuController {

    @Autowired
    private PhongChieuService phongChieuService;

    @PostMapping
    public PhongChieu createPhongChieu(@RequestBody PhongChieu phongChieu) {
        return phongChieuService.savePhongChieu(phongChieu);
    }

    @GetMapping
    public List<PhongChieu> getAllPhongChieus() {
        return phongChieuService.getAllPhongChieus();
    }

    @GetMapping("/{id}")
    public PhongChieu getPhongChieuById(@PathVariable Long id) {
        return phongChieuService.getPhongChieuById(id);
    }


    @GetMapping("/rap/{rap-id}")
    public ResponseEntity<List<PhongChieu>> findAllStudents(
            @PathVariable("rap-id") Long rapId
    ) {
        return ResponseEntity.ok(phongChieuService.getAllPhongchieusByRap(rapId));
    }

    @DeleteMapping("/{id}")
    public String deletePhongChieu(@PathVariable Long id) {
        phongChieuService.deletePhongChieuById(id);
        return "Deleted PhongChieu with ID: " + id;
    }

    @PutMapping("/{id}")
    public PhongChieu updatePhongChieu(@PathVariable Long id, @RequestBody PhongChieu phongChieu) {
        return phongChieuService.updatePhongChieu(id, phongChieu);
    }
}
