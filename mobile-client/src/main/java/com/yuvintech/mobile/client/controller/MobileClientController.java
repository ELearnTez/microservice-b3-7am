package com.yuvintech.mobile.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvintech.mobile.client.service.MobileClientService;
import com.yuvintech.msk.common.dto.MobileClientDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("mobile-client")
public class MobileClientController {

	@Autowired
	private MobileClientService mobileClientService;
	
	
	@GetMapping
	public Flux<MobileClientDto> getAllMobileDetails(){
		return mobileClientService.getAllMobileInfo();
	}
	
	@GetMapping("{mobile-id}")
	public Mono<MobileClientDto> getAllMobileDetails(@PathVariable("mobile-id") int id){
		return mobileClientService.getAllMobileInfo(id);
	}
}
