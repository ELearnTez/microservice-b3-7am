package com.yuvintech.spring.boot.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuvintech.spring.boot.country.data.City;
import com.yuvintech.spring.boot.country.data.Country;
import com.yuvintech.spring.boot.country.repository.CountryRepository;


@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.getAllCountries();
	}


	@Override
	public Country getCountryInfoByCode(String countryCode) {
		return countryRepository.getCountryInfoByCode(countryCode);
	}


	@Override
	public City getCityByName(String cityName) {
		return countryRepository.getCityByName(cityName);
	}


	

}
