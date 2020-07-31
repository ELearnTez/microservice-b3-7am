package com.yuvintech.msk.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class City {

	private int id;
	
	private String name;
	
	private String countryCode;
	
	private String district;
	
	private long population;

	
	
}
