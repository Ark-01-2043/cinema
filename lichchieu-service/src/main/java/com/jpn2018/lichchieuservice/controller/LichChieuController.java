package com.jpn2018.lichchieuservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpn2018.lichchieuservice.dto.LichChieuDto;
import com.jpn2018.lichchieuservice.entity.LichChieu;
import com.jpn2018.lichchieuservice.service.LichChieuService;

import java.util.List;

@RestController
@RequestMapping("/api/lichchieus")
@CrossOrigin(origins = "http://localhost:3000")
public class LichChieuController {

    @Autowired
    private LichChieuService lichChieuService;

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
    public LichChieu getLichChieuById(@PathVariable Long id) {
        return lichChieuService.getLichChieuById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteLichChieu(@PathVariable Long id) {
        lichChieuService.deleteLichChieuById(id);
        return "Deleted LichChieu with ID: " + id;
    }

    @PutMapping("/{id}")
    public LichChieu updateLichChieu(@PathVariable Long id, @RequestBody LichChieu lichChieu) {
        return lichChieuService.updateLichChieu(id, lichChieu);
    }

    @GetMapping("/phim/{phimId}")
    public List<LichChieu> getLichChieuByPhim(@PathVariable Long phimId) {
        return lichChieuService.findLichChieuByPhimId(phimId);
    }
}
