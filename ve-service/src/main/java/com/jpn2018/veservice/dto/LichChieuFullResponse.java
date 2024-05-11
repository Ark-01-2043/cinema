package com.jpn2018.veservice.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LichChieuFullResponse {

    private Long id;

    private int price;

    private LocalDate date;


    private Phim phim;


    private PhongChieuFullResponse phongChieu;


    private KhungGio khungGio;
}