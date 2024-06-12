package com.jpn2018.dichvuservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.dichvuservice.client.ProgressClient;
import com.jpn2018.dichvuservice.entity.DichVu;
import com.jpn2018.dichvuservice.service.DichVuRedisService;
import com.jpn2018.dichvuservice.service.DichVuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dichvus")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class DichVuController {

    //    @Autowired
//    private SimpMessageSendingOperations messagingTemplate;
    @Autowired
    private DichVuService dichVuService;

    @Autowired
    private DichVuRedisService dichVuRedisService;

    @Autowired
    private ProgressClient progressClient;

    @PostMapping
    public DichVu createDichVu(@RequestBody DichVu dichVu) {
        return dichVuService.saveDichVu(dichVu);
    }

    //    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
    @GetMapping
    public List<DichVu> getAllDichVus() {
        String content = "gui thong tin dich vu";
        int percentage = 50;
        System.out.println(content);
//        progressClient.sendProgress(content, percentage);
        return dichVuService.getAllDichVus();
    }

    @GetMapping("/{id}")
    public DichVu getDichVuById(@PathVariable Long id) throws JsonMappingException, JsonProcessingException {
        DichVu dichVu = dichVuRedisService.getDichVuById(id);
        if (dichVu == null) {
            dichVu = dichVuService.getDichVuById(id);
            dichVuRedisService.saveDichVu(dichVu);
        }
        return dichVu;
    }

    @DeleteMapping("/{id}")
    public String deleteDichVu(@PathVariable Long id) {
        dichVuService.deleteDichVuById(id);
        dichVuRedisService.deleteDichVu(id);
        return "Deleted DichVu with ID: " + id;
    }

    @PutMapping("/{id}")
    public DichVu updateDichVu(@PathVariable Long id, @RequestBody DichVu dichVu) throws JsonProcessingException {
        DichVu newDichVu = dichVuService.updateDichVu(id, dichVu);
        dichVuRedisService.deleteDichVu(id);
        dichVuRedisService.saveDichVu(newDichVu);
        return newDichVu;
    }
}
