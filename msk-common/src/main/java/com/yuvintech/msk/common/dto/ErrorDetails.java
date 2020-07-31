package com.yuvintech.msk.common.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	
	private int code;
	
	private String message;
	
	
	
	

}
