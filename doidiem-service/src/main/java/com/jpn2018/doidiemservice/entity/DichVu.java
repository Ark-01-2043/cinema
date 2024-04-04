package com.jpn2018.doidiemservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DichVu {

    private Long id;
    private String name;
    private int price;
    private int point;
    private String image;
    private String description;
}
