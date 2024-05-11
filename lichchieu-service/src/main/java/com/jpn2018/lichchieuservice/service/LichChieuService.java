package com.jpn2018.lichchieuservice.service;

import com.jpn2018.lichchieuservice.dto.LichChieuDto;
import com.jpn2018.lichchieuservice.entity.LichChieu;
import com.jpn2018.lichchieuservice.entity.LichChieuFullResponse;

import java.util.List;

public interface LichChieuService {

    List<LichChieuFullResponse> findLichChieuByPhimId(Long phimId);

    LichChieu saveLichChieu(LichChieu lichChieu);

    List<LichChieu> getAllLichChieus();

    LichChieu getLichChieuById(Long id);

    List<LichChieuDto> getAllLichChieuDtos();

    LichChieuDto getLichChieuDtoById(Long id);

    void deleteLichChieuById(Long id);

    LichChieu updateLichChieu(Long id, LichChieu lichChieu);

    LichChieuFullResponse getLichChieuFullResponseById(Long id);
}