package com.yuvintech.msk.common.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mobile")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private  String name;
	
	private Double price;
	
	private Status status;
	
	@Column(name="pubication_date")
	private LocalDate publicationDate;
	
	@Column(name="line_of_business")
	private LineOfBusiness lineOfBusiness;
	
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="accessory_type")
	private String accessoryType;
	

}
