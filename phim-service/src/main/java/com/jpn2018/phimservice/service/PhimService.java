package com.jpn2018.phimservice.service;

import com.jpn2018.phimservice.entity.Phim;

import java.util.List;

public interface PhimService {
    Phim savePhim(Phim phim);

    List<Phim> getListPhim();

    Phim getPhimById(Long phimId);

    void deletePhimById(Long phimId);

    Phim updatePhim(Long phimId, Phim phim);
}
