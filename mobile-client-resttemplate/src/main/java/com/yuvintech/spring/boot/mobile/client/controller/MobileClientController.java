package com.yuvintech.spring.boot.mobile.client.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuvintech.spring.boot.mobile.client.data.Mobile;

@RestController
@RequestMapping("mobile-client")
public class MobileClientController {

	
	@Autowired
	private RestTemplate mobileServiceTemplate;
	
	@GetMapping("/{mobile-id}")
	public Mobile getMobileByIdFromMobileService(@PathVariable("mobile-id") int mobileId) throws JsonMappingException, JsonProcessingException{
		
		ResponseEntity<String> mobileresponse = mobileServiceTemplate.getForEntity("http://localhost:8080/mobile/"+mobileId, String.class);
		
        if(mobileresponse.getStatusCode() == HttpStatus.OK) {
        	// Success Scenario - Mobile
        	Mobile mobile = new ObjectMapper().readValue(mobileresponse.getBody(), Mobile.class);
        	
        }else {
        	// Error Details
        	
        }
		
		
		System.out.println("mobile reponse status code : "+ mobileresponse.getStatusCode());
		
		return null;	
		
	}
	
	
	@GetMapping
	public List<Mobile> getAllMobilesFromMobileService() throws RestClientException, URISyntaxException{
		
		
		ResponseEntity<List<Mobile>>  responseEntity =  mobileServiceTemplate
				.exchange(new URI("http://localhost:8080/mobile"), HttpMethod.GET, null, 
						
						new ParameterizedTypeReference<List<Mobile>>(){}
				
						
						);
		System.out.println("mobile reponse status code : "+ responseEntity.getStatusCode());
		return responseEntity.getBody();
	}
	
	
}
