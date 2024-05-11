package com.jpn2018.veservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhungGio {


    private Long id;
    private String timeStart;
    private String timeEnd;

}
