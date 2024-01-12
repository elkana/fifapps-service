package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StructureCreditDto {
	private Integer id;
	private String code;
	private String applCode;
	private BigDecimal principal;
}
