package com.yuvintech.spring.boot.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvintech.msk.common.dto.City;
import com.yuvintech.msk.common.dto.Country;
import com.yuvintech.spring.boot.country.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping
	public List<Country> getAllCountries(){		
		return countryService.getAllCountries();		
	}
	
	@GetMapping("/{country-code}")
	public Country getCountryInfoByCode(@PathVariable("country-code") String countryCode) {
		return countryService.getCountryInfoByCode(countryCode);
	}
	
	@GetMapping("/city/{city-name}")
	public City getCityByName(@PathVariable("city-name") String cityName) {
		return countryService.getCityByName(cityName);
	}
	

}
