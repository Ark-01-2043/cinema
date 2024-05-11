package com.jpn2018.hoadonservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Long thanhVienId;
    private int hinhThucThanhToanId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "hoadon_id",
            referencedColumnName = "id"
    )
    private List<ChiTietDichVu> chiTietDichVus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "hoadon_id",
            referencedColumnName = "id"
    )
    private List<ChiTietVe> chiTietVes;

}
