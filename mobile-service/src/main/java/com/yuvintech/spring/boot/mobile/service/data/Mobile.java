package com.yuvintech.spring.boot.mobile.service.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {

	private int id;

	private String name;

	private String status;

	private String lob;

	private String countryCode;

	private String publicationDate;

	private double price;

	private String accessoryType;

}
