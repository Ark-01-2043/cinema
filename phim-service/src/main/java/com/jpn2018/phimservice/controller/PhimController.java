package com.jpn2018.phimservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.phimservice.client.ProgressClient;
import com.jpn2018.phimservice.entity.Phim;
import com.jpn2018.phimservice.service.PhimRedisService;
import com.jpn2018.phimservice.service.PhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phims")
@CrossOrigin(origins = "http://localhost:3000")
public class PhimController {

    @Autowired
    PhimService phimService;
    @Autowired
    ProgressClient progressClient;
    @Autowired
    private PhimRedisService phimRedisService;

    @RequestMapping(method = RequestMethod.POST, value = "")
    public Phim savePhim(@RequestBody Phim phim) {
        return phimService.savePhim(phim);
    }

    @GetMapping("")
    public List<Phim> getListPhim() {
        String content = "get list film";
        int percentage = 30;
//        progressClient.sendProgress(content, percentage);
        return phimService.getListPhim();
    }

    @GetMapping("/{id}")
    public Phim getPhimById(@PathVariable("id") Long phimId) throws JsonMappingException, JsonProcessingException {
        Phim phim = phimRedisService.getPhimById(phimId);
        if (phim == null) {
            phim = phimService.getPhimById(phimId);
            phimRedisService.savePhim(phim);
        }
        return phim;
    }

    @DeleteMapping("/{id}")
    public String deletePhimById(@PathVariable("id") Long phimId) {
        phimService.deletePhimById(phimId);
        phimRedisService.deletePhim(phimId);
        return "delete phim successfully";
    }

    @PutMapping("/{id}")
    public Phim updatePhim(@PathVariable("id") Long phimId,
                           @RequestBody Phim phim) throws JsonProcessingException {
        Phim newPhim = phimService.updatePhim(phimId, phim);
        phimRedisService.deletePhim(phimId);
        phimRedisService.savePhim(newPhim);
        return newPhim;
    }

}
