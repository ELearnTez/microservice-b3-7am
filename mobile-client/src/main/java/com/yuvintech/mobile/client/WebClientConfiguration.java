package com.yuvintech.mobile.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;
import lombok.Builder;



@Configuration
public class WebClientConfiguration {

	
	@Value("${mobile-service-base-uri}")
	private String mobileServiceBaseUri;
	
	@Value("${country-service-base-uri}")
	private String countryServiceBaseUri;
	
	@Value("${mobile-accessory-base-uri}")
	private String accessoryServiceBaseUri;
	
	
	
	@Bean
	public WebClient mobileServiceClient() {
		return WebClient
				 .builder()
				 .filter(basicAuthentication("mobile-service-user","mobile-service-user123"))
				 .baseUrl(mobileServiceBaseUri)
				 .build();
	}
	
	
	@Bean
	public WebClient countryServiceClient() {
		return WebClient
				 .builder()
				 .filter(basicAuthentication("country-user", "country-user"))
				 .baseUrl(countryServiceBaseUri)
				 .build();
	}
	
	
	@Bean
	public WebClient accessoryServiceClient() {
		return WebClient
				 .builder()
				 .baseUrl(accessoryServiceBaseUri)
				 .build();
	}
	
	
}
