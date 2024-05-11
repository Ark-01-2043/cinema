package com.jpn2018.lichchieuservice.entity;


import com.jpn2018.lichchieuservice.dto.KhungGio;
import com.jpn2018.lichchieuservice.dto.Phim;
import com.jpn2018.lichchieuservice.dto.PhongChieuFullResponse;
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
