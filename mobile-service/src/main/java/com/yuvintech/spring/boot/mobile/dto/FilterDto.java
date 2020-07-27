package com.yuvintech.spring.boot.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto {
	
	private String name;
	 
    private  double price;
    
    private String status;
    
    private String lob;
	
	
}
