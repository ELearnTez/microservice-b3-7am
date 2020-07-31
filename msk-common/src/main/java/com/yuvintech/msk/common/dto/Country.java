package com.yuvintech.msk.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	
	private String code;
	
	private String name;
	
	private String description;
	
	private String region;
	
	private long population;

}
