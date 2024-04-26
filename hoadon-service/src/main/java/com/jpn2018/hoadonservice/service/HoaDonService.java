package com.jpn2018.hoadonservice.service;
import java.util.List;

import com.jpn2018.hoadonservice.dto.HoaDonDto;
import com.jpn2018.hoadonservice.entity.HoaDon;
import com.jpn2018.hoadonservice.exception.ThanhVienNotFoundException;

public interface HoaDonService {
    HoaDon saveHoaDon(HoaDon hoaDon);
    List<HoaDon> getAllHoaDons();

    HoaDon getHoaDonById(Long id);

    void deleteHoaDonById(Long id);
    HoaDon updateHoaDon(Long id, HoaDon hoaDon);
    HoaDonDto toDto(HoaDon hoaDon)  throws ThanhVienNotFoundException ;
    List<HoaDonDto> getAllDtos()  throws ThanhVienNotFoundException ;
    HoaDonDto getDtoById(Long id)  throws ThanhVienNotFoundException ;
    HoaDonDto datVe(HoaDon hoaDon) throws ThanhVienNotFoundException ;
   
}