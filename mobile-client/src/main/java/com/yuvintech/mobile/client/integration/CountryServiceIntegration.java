package com.yuvintech.mobile.client.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.yuvintech.msk.common.dto.Country;

import reactor.core.publisher.Mono;

@Component
public class CountryServiceIntegration {

	@Autowired
	private WebClient countryServiceClient;
	
	
	public Mono<Country> getCountryInfoByCode(String countryCode){
		
		
		return countryServiceClient
		         .get()
		         .uri("/{country-code}", countryCode)
		         .retrieve()
		         .bodyToMono(Country.class);
		                   
		 
		 
		
		
	}
	
}
