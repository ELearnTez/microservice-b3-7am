package com.yuvintech.msk.common.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobileClientDto {
	
	private int id;

	private int port;
	
	private String name;

	private double price;

	private String status;

	private LocalDate publicationDate;

	private String lineOfBusiness;
	
	private Country country;
	
	private List<MobileAccessoryDto> accessoryInfo;

}
