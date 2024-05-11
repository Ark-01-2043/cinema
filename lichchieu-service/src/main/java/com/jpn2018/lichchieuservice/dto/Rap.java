package com.jpn2018.lichchieuservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rap {

    private Long id;
    private String name;
    private String address;
    private String tel;
    private String description;

}
