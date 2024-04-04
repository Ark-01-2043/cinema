package com.jpn2018.doidiemservice.entity;

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
public class HoaDonDoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Long thanhVienId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "hoadondoi_id",
            referencedColumnName = "id"
    )
    private List<ChiTietDoi> chiTietDois;
}
