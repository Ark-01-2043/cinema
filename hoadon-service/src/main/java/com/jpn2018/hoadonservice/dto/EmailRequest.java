package com.jpn2018.hoadonservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequest {

    private String toEmail;
    private String subject;
    private String body;

}
