package com.yuvintech.spring.boot.country.service;

import java.util.List;

import com.yuvintech.msk.common.dto.City;
import com.yuvintech.msk.common.dto.Country;

public interface CountryService {

	
	public List<Country> getAllCountries();

	public Country getCountryInfoByCode(String countryCode);

	
	public City getCityByName(String cityName);
}
