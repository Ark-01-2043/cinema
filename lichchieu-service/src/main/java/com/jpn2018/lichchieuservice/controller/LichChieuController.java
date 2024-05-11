package com.jpn2018.lichchieuservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.lichchieuservice.dto.LichChieuDto;
import com.jpn2018.lichchieuservice.entity.LichChieu;
import com.jpn2018.lichchieuservice.entity.LichChieuFullResponse;
import com.jpn2018.lichchieuservice.service.LichChieuRedisService;
import com.jpn2018.lichchieuservice.service.LichChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lichchieus")
@CrossOrigin(origins = "http://localhost:3000")
public class LichChieuController {

    @Autowired
    private LichChieuService lichChieuService;
    @Autowired
    private LichChieuRedisService lichChieuRedisService;
    @PostMapping
    public LichChieu createLichChieu(@RequestBody LichChieu lichChieu) {
        return lichChieuService.saveLichChieu(lichChieu);
    }

    @GetMapping
    public List<LichChieu> getAllLichChieus() {
        return lichChieuService.getAllLichChieus();
    }

    @GetMapping("/dtos")
    public ResponseEntity<List<LichChieuDto>> getAllLichChieuDtos() {
        return ResponseEntity.ok(lichChieuService.getAllLichChieuDtos());
    }

    @GetMapping("/dtos/{id}")
    public ResponseEntity<LichChieuDto> getLichChieuDtoById(@PathVariable Long id) {
        return ResponseEntity.ok(lichChieuService.getLichChieuDtoById(id));
    }

    @GetMapping("/{id}")
    public LichChieu getLichChieuById(@PathVariable Long id) throws JsonMappingException, JsonProcessingException {
    	LichChieu lichChieu = lichChieuRedisService.getLichChieuByid(id);
    	if (lichChieu == null) {
			lichChieu = lichChieuService.getLichChieuById(id);
			lichChieuRedisService.saveLichChieu(lichChieu);
		}
        return lichChieu; 
    }

    @GetMapping("/{id}/full")
    public LichChieuFullResponse getLichChieuFullResponseById(@PathVariable Long id) throws JsonMappingException, JsonProcessingException {
    	LichChieuFullResponse lichChieuFullResponse = lichChieuRedisService.getLichChieuFullById(id);
    	if (lichChieuFullResponse == null) {
			lichChieuFullResponse = lichChieuService.getLichChieuFullResponseById(id);
			lichChieuRedisService.saveLichChieuFull(lichChieuFullResponse);
		}
        return lichChieuFullResponse;
    }

    @DeleteMapping("/{id}")
    public String deleteLichChieu(@PathVariable Long id) {
        lichChieuService.deleteLichChieuById(id);
        lichChieuRedisService.deleteLichChieu(id);
        return "Deleted LichChieu with ID: " + id;
    }

    @PutMapping("/{id}")
    public LichChieu updateLichChieu(@PathVariable Long id, @RequestBody LichChieu lichChieu) throws JsonProcessingException {
        LichChieu newLichChieu = lichChieuService.updateLichChieu(id, lichChieu);
        lichChieuRedisService.deleteLichChieu(id);
        lichChieuRedisService.saveLichChieu(newLichChieu);
    	return newLichChieu;
    }

    @GetMapping("/phim/{phimId}")
    public List<LichChieuFullResponse> getLichChieuByPhim(@PathVariable Long phimId) throws JsonMappingException, JsonProcessingException {
        List<LichChieuFullResponse> list = lichChieuRedisService.getDSLichChieuByPhim(phimId);
        if (list == null) {
			list = lichChieuService.findLichChieuByPhimId(phimId);
			lichChieuRedisService.saveDSLichChieuByPhim(list);
		}
    	return list;
    }
}
