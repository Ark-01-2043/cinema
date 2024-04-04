package com.jpn2018.khunggioservice.service;
import java.util.List;

import com.jpn2018.khunggioservice.entity.KhungGio;

public interface KhungGioService {
    KhungGio saveKhungGio(KhungGio khungGio);

    List<KhungGio> getAllKhungGios();

    KhungGio getKhungGioById(Long id);

    void deleteKhungGioById(Long id);

    KhungGio updateKhungGio(Long id, KhungGio khungGio);
}