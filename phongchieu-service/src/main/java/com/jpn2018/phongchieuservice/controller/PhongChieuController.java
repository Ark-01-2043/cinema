package com.jpn2018.phongchieuservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.phongchieuservice.entity.PhongChieu;
import com.jpn2018.phongchieuservice.service.PhongChieuRedisService;
import com.jpn2018.phongchieuservice.service.PhongChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phongchieus")
public class PhongChieuController {

    @Autowired
    private PhongChieuService phongChieuService;
    @Autowired
    private PhongChieuRedisService phongChieuRedisService;
    @PostMapping
    public PhongChieu createPhongChieu(@RequestBody PhongChieu phongChieu) {
        return phongChieuService.savePhongChieu(phongChieu);
    }

    @GetMapping
    public List<PhongChieu> getAllPhongChieus() {
        return phongChieuService.getAllPhongChieus();
    }

    @GetMapping("/{id}")
    public PhongChieu getPhongChieuById(@PathVariable Long id) throws JsonMappingException, JsonProcessingException {
        PhongChieu phongChieu = phongChieuRedisService.getPhongChieuById(id);
        if (phongChieu == null) {
			phongChieu = phongChieuService.getPhongChieuById(id);
			phongChieuRedisService.savePhongChieu(phongChieu);
		}
    	return phongChieu;
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
        phongChieuRedisService.deletePhongChieu(id);
        return "Deleted PhongChieu with ID: " + id;
    }

    @PutMapping("/{id}")
    public PhongChieu updatePhongChieu(@PathVariable Long id, @RequestBody PhongChieu phongChieu) throws JsonProcessingException {
        PhongChieu newPhongChieu = phongChieuService.updatePhongChieu(id, phongChieu);
        phongChieuRedisService.deletePhongChieu(id);
        phongChieuRedisService.savePhongChieu(newPhongChieu);
    	return newPhongChieu;
    }
}
