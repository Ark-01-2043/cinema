package com.jpn2018.hoadonservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThanhVien {

    
    private Long id;

    
    private String email;

    private String password;
    private String name;
    private LocalDate date;
    private String address;
    private String tel;
    private int point;

    @Override
    public String toString() {
        return "ThanhVien{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", point=" + point +
                '}';
    }
}
