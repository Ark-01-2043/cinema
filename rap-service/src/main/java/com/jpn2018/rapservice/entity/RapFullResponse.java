package com.jpn2018.rapservice.entity;


import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RapFullResponse {
    private String name;
    private String address;
    private String tel;
    private String description;
    private List<PhongChieu> phongChieus;
}
