package com.jpn2018.thanhtoanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
	private String payerId;
	private Double total;
	private String currency;
	private String method;
	private String intent;
	private String description;
}
