package com.jpn2018.veservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeFullResponse {

    private Long id;
    private LichChieuFullResponse lichChieu;
    private Ghe ghe;
    private Boolean booked;
}
