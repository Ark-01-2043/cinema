package com.jpn2018.dichvuservice.service;

import java.util.List;

import com.jpn2018.dichvuservice.entity.DichVu;

public interface DichVuService {
    DichVu saveDichVu(DichVu dichVu);

    List<DichVu> getAllDichVus();

    DichVu getDichVuById(Long id);

    void deleteDichVuById(Long id);

    DichVu updateDichVu(Long id, DichVu dichVu);
}