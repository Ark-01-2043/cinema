package com.jpn2018.thanhvienservice.service;

import com.jpn2018.thanhvienservice.entity.ThanhVien;
import com.jpn2018.thanhvienservice.error.ThanhVienNotFoundException;

import java.util.List;

public interface ThanhVienService {


    ThanhVien saveThanhVien(ThanhVien thanhVien);

    List<ThanhVien> getAllThanhViens();

    ThanhVien getThanhVienById(Long id) throws ThanhVienNotFoundException;

    void deleteThanhVienById(Long id);

    ThanhVien login(ThanhVien thanhVien) throws ThanhVienNotFoundException;

    ThanhVien getThanhVienByEmail(String email);

//    ThanhVien updateThanhVien(Long id, ThanhVien thanhVien);

//    ThanhVien login(ThanhVien thanhVien) throws ThanhVienNotFoundException;

//    void changePassword(ChangePasswordRequest request, Principal connectedUser);
}
