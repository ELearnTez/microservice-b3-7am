package com.yuvintech.mobile.service.functional.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;



import lombok.Data;

@Validated
@Data
public class SaveMobileDto {

	@javax.validation.constraints.NotNull
	private String name;
	
	@Min(value = 1)
	private double price;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String lineOfBusiness;
	
	@NotBlank
	private String countryCode;
	
	private String accessoryType;
	
	
}
