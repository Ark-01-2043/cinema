package com.jpn2018.progressservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Progress {

    private String method;
    private int statusCode;
    private String content;
    private int percentage;


}
