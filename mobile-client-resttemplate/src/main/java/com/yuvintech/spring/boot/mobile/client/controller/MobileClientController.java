package com.yuvintech.spring.boot.mobile.client.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.yuvintech.spring.boot.mobile.client.data.Mobile;

@RestController
@RequestMapping("mobile-client")
public class MobileClientController {

	
	@Autowired
	private RestTemplate mobileServiceTemplate;
	
	@GetMapping("/{mobile-id}")
	public Mobile getMobileByIdFromMobileService(@PathVariable("mobile-id") int mobileId){
		
		ResponseEntity<Mobile> mobileresponse = mobileServiceTemplate.getForEntity("http://localhost:8080/mobile/"+mobileId, Mobile.class);
		
		System.out.println("mobile reponse status code : "+ mobileresponse.getStatusCode());
		
		return mobileresponse.getBody();	
		
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
