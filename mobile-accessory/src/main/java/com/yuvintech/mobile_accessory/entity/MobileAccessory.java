package com.yuvintech.mobile_accessory.entity;

import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
public class MobileAccessory {
	
	
	@Id
	private UUID id;
	
	private String name;
	
	private String description;
	
	private String mobileType;
	
	
	private Boolean isActive;
	

}
