package com.yuvintech.msk.common.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveMobileDto {

	@NotBlank(message = "{NotBlank.SaveMobileDto.name}")
	private String name;

	@Min(value = 1, message = "{Min.SaveMobileDto.price}")
	private double price;

	@NotBlank(message = "{NotBlank.SaveMobileDto.status}")
	private String status;

	@NotBlank(message = "{NotBlank.SaveMobileDto.lineOfBusiness}")
	private String lineOfBusiness;

	@NotBlank(message = "{NotBlank.SaveMobileDto.countryCode}")
	private String countryCode;

	private String accessoryType;

}
