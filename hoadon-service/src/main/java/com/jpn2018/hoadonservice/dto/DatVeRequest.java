package com.jpn2018.hoadonservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatVeRequest {
	private Long thanhVienId;
	private List<Long> dichvus;
	private List<Long> ves;
}
