package com.jpn2018.gheservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jpn2018.gheservice.entity.Ghe;
import com.jpn2018.gheservice.service.GheRedisService;
import com.jpn2018.gheservice.service.GheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ghes")
@CrossOrigin(origins = "http://localhost:3000")
public class GheController {

    @Autowired
    GheService gheService;
    @Autowired
    private GheRedisService gheRedisService;
    @PostMapping("")
    public Ghe saveGhe(@RequestBody Ghe ghe) {
        return gheService.saveGhe(ghe);
    }

    @GetMapping("")
    public List<Ghe> getListGhe() {
        return gheService.getListGhe();
    }

    @GetMapping("/{id}")
    public Ghe getGheById(@PathVariable("id") Long gheId) throws JsonProcessingException {
    	Ghe ghe = gheRedisService.getGheById(gheId);
    	if (ghe == null) {
			ghe = gheService.getGheById(gheId);
			gheRedisService.saveGhe(ghe);
		}
        return ghe;
    }

    @DeleteMapping("/{id}")
    public String deleteGheById(@PathVariable("id") Long gheId) {
        gheService.deleteGheById(gheId);
        gheRedisService.deleteGhe(gheId);
        return "delete ghe successfully";
    }

    @PutMapping("/{id}")
    public Ghe updateGhe(@PathVariable("id") Long gheId,
                         @RequestBody Ghe ghe) throws JsonProcessingException {
        Ghe newGhe = gheService.updateGhe(gheId, ghe);
        gheRedisService.deleteGhe(gheId);
        gheRedisService.saveGhe(newGhe);
    	return newGhe;
    }
    
}
