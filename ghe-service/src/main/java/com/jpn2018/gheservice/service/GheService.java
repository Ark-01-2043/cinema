package com.jpn2018.gheservice.service;

import com.jpn2018.gheservice.entity.Ghe;

import java.util.List;

public interface GheService {
    Ghe saveGhe(Ghe ghe);

    List<Ghe> getListGhe();

    Ghe getGheById(Long gheId);

    void deleteGheById(Long gheId);

    Ghe updateGhe(Long gheId, Ghe ghe);
}
