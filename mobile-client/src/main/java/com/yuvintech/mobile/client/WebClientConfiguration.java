package com.yuvintech.mobile.client;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;



@Configuration
public class WebClientConfiguration {

	
	@Value("${loadbalancer-base-uri}")
	private String loadbalancerbaseuri;
	
	@Bean
	public WebClient mobileServiceClient() {
		return WebClient
				 .builder()
				 .filter(basicAuthentication("mobile-service-user","mobile-service-user"))
				 .baseUrl(loadbalancerbaseuri+"/mobile-service/msk/mobiles")
				 .build();
	}
	
	
	@Bean
	public WebClient countryServiceClient() {
		
		return WebClient
				 .builder()
				 .filter(basicAuthentication("country-user", "country-user"))
				 .baseUrl(loadbalancerbaseuri+"/country-service/msk/countries")
				 .build();
	}
	
	
	@Bean
	public WebClient accessoryServiceClient() {
		
		return WebClient
				 .builder()
				 .baseUrl(loadbalancerbaseuri+"/mobile-accessory/mobile-accessories")
				 .build();
	}
	
	
}
