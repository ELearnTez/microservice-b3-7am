package com.yuvintech.msk.common.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileDto {

	private int id;
	
	private int port;

	private String name;

	private double price;

	private String status;

	private LocalDate publicationDate;

	private String lineOfBusiness;

	private String countryCode;

	private String accessoryType;

}
