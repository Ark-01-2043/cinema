package com.jpn2018.doidiemservice.service;

import com.jpn2018.doidiemservice.entity.HoaDonDoi;

import java.util.List;

public interface HoaDonDoiService {
    HoaDonDoi saveHoaDonDoi(HoaDonDoi hoaDonDoi);

    List<HoaDonDoi> getAllHoaDonDois();

    HoaDonDoi getHoaDonDoiById(Long id);

    void deleteHoaDonDoiById(Long id);

    HoaDonDoi updateHoaDonDoi(Long id, HoaDonDoi hoaDonDoi);
}
