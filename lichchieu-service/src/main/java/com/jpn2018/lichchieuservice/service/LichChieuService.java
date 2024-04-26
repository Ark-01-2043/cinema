package com.jpn2018.lichchieuservice.service;
import java.util.List;

import com.jpn2018.lichchieuservice.dto.LichChieuDto;
import com.jpn2018.lichchieuservice.entity.LichChieu;

public interface LichChieuService {

    List<LichChieu> findLichChieuByPhimId(Long phimId);

    LichChieu saveLichChieu(LichChieu lichChieu);

    List<LichChieu> getAllLichChieus();

    LichChieu getLichChieuById(Long id);
    List<LichChieuDto> getAllLichChieuDtos();

    LichChieuDto getLichChieuDtoById(Long id);
    void deleteLichChieuById(Long id);

    LichChieu updateLichChieu(Long id, LichChieu lichChieu);
}