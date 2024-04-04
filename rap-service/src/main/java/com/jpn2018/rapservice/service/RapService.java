package com.jpn2018.rapservice.service;

import com.jpn2018.rapservice.entity.Rap;
import com.jpn2018.rapservice.entity.RapFullResponse;

import java.util.List;

public interface RapService {
    Rap saveRap(Rap rap);

    List<Rap> getListRap();

    RapFullResponse findRapsWithPhongchieus(Long rapId);

    Rap getRapById(Long rapId);

    void deleteRapById(Long rapId);

    Rap updateRap(Long rapId, Rap rap);
}
