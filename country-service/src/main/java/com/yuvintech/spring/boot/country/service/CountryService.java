package com.yuvintech.spring.boot.country.service;

import java.util.List;

import com.yuvintech.spring.boot.country.data.City;
import com.yuvintech.spring.boot.country.data.Country;

public interface CountryService {

	
	public List<Country> getAllCountries();

	public Country getCountryInfoByCode(String countryCode);

	
	public City getCityByName(String cityName);
}
