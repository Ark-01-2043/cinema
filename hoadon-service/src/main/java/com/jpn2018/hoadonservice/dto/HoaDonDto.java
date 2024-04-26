package com.jpn2018.hoadonservice.dto;

import java.time.LocalDate;
import java.util.List;

import com.jpn2018.hoadonservice.entity.ChiTietDichVu;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonDto {
	
    private Long id;
    private LocalDate date;
    private ThanhVien thanhVien;
    private String hinhThucThanhToan;
    private List<Ve> ves;
    private List<DichVu> dichVus;
}
