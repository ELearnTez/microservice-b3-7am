package com.yuvintech.msk.common.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MobileAccessoryDto {
	
	private UUID id;
	
	private String name;
	
	private String description;
	
	private String mobileType;
	
	
	private boolean isActive;
	

}
