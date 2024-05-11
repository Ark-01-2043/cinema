package com.jpn2018.veservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhongChieuFullResponse {

    private Long id;
    private String name;
    private int capacity;
    private String description;
    private Rap rap;
}
