package com.jpn2018.doidiemservice.service;

import com.jpn2018.doidiemservice.entity.ChiTietDoi;

import java.util.List;

public interface ChiTietDoiService {
    ChiTietDoi saveChiTietDoi(ChiTietDoi chiTietDoi);

    List<ChiTietDoi> getListChiTietDoi();

    ChiTietDoi getChiTietDoiById(Long chiTietDoiId);

    void deleteChiTietDoiById(Long chiTietDoiId);

    ChiTietDoi updateChiTietDoi(Long chiTietDoiId, ChiTietDoi chiTietDoi);
}
