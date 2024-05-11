package com.jpn2018.rapservice.controller;

import com.jpn2018.rapservice.entity.Rap;
import com.jpn2018.rapservice.entity.RapFullResponse;
import com.jpn2018.rapservice.service.RapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/raps")
public class RapController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RapController.class);

    @Autowired
    RapService rapService;

    @RequestMapping(method = RequestMethod.POST, value = "")
    public Rap saveRap(@RequestBody Rap rap) {
        return rapService.saveRap(rap);
    }

    @GetMapping("")
    public List<Rap> getListRap() {
        return rapService.getListRap();
    }

    @GetMapping("/{id}")
    public Rap getRapById(@PathVariable("id") Long rapId) {
        LOGGER.info("Rap find: id={}", rapId);
        return rapService.getRapById(rapId);
    }

    @GetMapping("/{rap-id}/with-phongchieus")
    public ResponseEntity<RapFullResponse> findAllSchools(
            @PathVariable("rap-id") Long rapId
    ) {
        return ResponseEntity.ok(rapService.findRapsWithPhongchieus(rapId));
    }

    @DeleteMapping("/{id}")
    public String deleteRapById(@PathVariable("id") Long rapId) {
        rapService.deleteRapById(rapId);
        return "delete rap successfully";
    }

    @PutMapping("/{id}")
    public Rap updateRap(@PathVariable("id") Long rapId,
                         @RequestBody Rap rap) {
        return rapService.updateRap(rapId, rap);
    }

}
