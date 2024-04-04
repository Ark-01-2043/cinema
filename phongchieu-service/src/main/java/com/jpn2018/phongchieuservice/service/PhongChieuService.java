package com.jpn2018.phongchieuservice.service;

import com.jpn2018.phongchieuservice.entity.PhongChieu;

import java.util.List;

public interface PhongChieuService {
    PhongChieu savePhongChieu(PhongChieu phongChieu);

    List<PhongChieu> getAllPhongChieus();

    public List<PhongChieu> getAllPhongchieusByRap(Long rapId);

    PhongChieu getPhongChieuById(Long id);

    void deletePhongChieuById(Long id);

    PhongChieu updatePhongChieu(Long id, PhongChieu phongChieu);
}
