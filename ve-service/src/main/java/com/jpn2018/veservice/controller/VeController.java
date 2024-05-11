package com.jpn2018.veservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.veservice.client.GheClient;
import com.jpn2018.veservice.client.LichChieuClient;
import com.jpn2018.veservice.dto.VeDto;
import com.jpn2018.veservice.dto.VeFullResponse;
import com.jpn2018.veservice.entity.Ve;
import com.jpn2018.veservice.service.VeRedisService;
import com.jpn2018.veservice.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ves")
@CrossOrigin(origins = "http://localhost:3000")
public class VeController {

    @Autowired
    private VeService veService;
    @Autowired
    private GheClient gheClient;
    @Autowired
    private LichChieuClient lichChieuClient;
    @Autowired
    private VeRedisService veRedisService;
    @PostMapping
    public Ve createVe(@RequestBody Ve ve) {
        return veService.saveVe(ve);
    }

    @GetMapping
    public List<Ve> getAllVes() {
        return veService.getAllVes();
    }

    @GetMapping("/{id}")
    public Ve getVeById(@PathVariable Long id) throws JsonMappingException, JsonProcessingException {
        Ve ve = veRedisService.getVeById(id);
        if (ve == null) {
			ve = veService.getVeById(id);
			veRedisService.saveVe(ve);
		}
    	return ve;
    }

    @DeleteMapping("/{id}")
    public String deleteVe(@PathVariable Long id) {
        veService.deleteVeById(id);
        veRedisService.deleteVe(id);
        return "Deleted Ve with ID: " + id;
    }

    @PutMapping("/{id}")
    public Ve updateVe(@PathVariable Long id, @RequestBody Ve ve) throws JsonProcessingException {
        Ve newVe = veService.updateVe(id, ve);
        veRedisService.saveVe(newVe);
    	return newVe;
    }

    @GetMapping("/lichchieus/{lichChieuId}")
    public List<VeFullResponse> getVeByLichChieu(@PathVariable Long lichChieuId) throws JsonMappingException, JsonProcessingException {
        List<VeFullResponse> list = veRedisService.getDSVeByLichChieu(lichChieuId);
        if (list == null) {
			list = veService.findVeByLichChieu(lichChieuId);
			veRedisService.saveDSVeByLichChieu(list);
		}
    	return list;
    }

    @GetMapping("/dtos")
    public ResponseEntity<?> getAllVeDtos() {
        return ResponseEntity.ok(veService.getAllVeDtos());
    }

    @GetMapping("/dtos/{id}")
    public ResponseEntity<VeDto> getVeDtoById(@PathVariable Long id) {
        return ResponseEntity.ok(veService.getVeDtoById(id));
    }
}
