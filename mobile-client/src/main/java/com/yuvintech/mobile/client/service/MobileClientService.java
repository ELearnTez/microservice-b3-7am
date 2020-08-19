package com.yuvintech.mobile.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuvintech.mobile.client.integration.CountryServiceIntegration;
import com.yuvintech.mobile.client.integration.MobileAccessoryIntegration;
import com.yuvintech.mobile.client.integration.MobileServiceIntegration;
import com.yuvintech.msk.common.dto.Country;
import com.yuvintech.msk.common.dto.MobileAccessoryDto;
import com.yuvintech.msk.common.dto.MobileClientDto;
import com.yuvintech.msk.common.dto.MobileDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class MobileClientService {
	
	
	@Autowired
	private MobileServiceIntegration mobileServiceIntegration;
	
	@Autowired
	private CountryServiceIntegration countryServiceIntegration;
	
	@Autowired
	private MobileAccessoryIntegration mobileAccessoryIntegration;
	
	
	
	public Flux<MobileClientDto> getAllMobileInfo(){
		 return  mobileServiceIntegration
				 .getAllMobiles()
				 .flatMap(mobile ->  getAllMobileInfo(mobile));
	}
	
	private Mono<MobileClientDto> getAllMobileInfo(MobileDto mobile) {
		Mono<Country> monoCountry =  countryServiceIntegration.getCountryInfoByCode(mobile.getCountryCode());
		 
		Mono<List<MobileAccessoryDto>> fluxAccessory = mobileAccessoryIntegration
				                                              .getAccessoryInfo(mobile.getAccessoryType())
				                                              .collectList();
		Mono<Tuple2<Country, List<MobileAccessoryDto>>> zippedResponse = Mono.zip(monoCountry, fluxAccessory);	
		
		return zippedResponse.flatMap(tuple -> {
			 Country country = tuple.getT1();
			 List<MobileAccessoryDto> accessory = tuple.getT2();
			 MobileClientDto finalResponse = MobileClientDto
					                                .builder()
					                                .id(mobile.getId())
					                                .lineOfBusiness(mobile.getLineOfBusiness())
					                                .status(mobile.getStatus())
					                                .name(mobile.getName())
					                                .price(mobile.getPrice())
					                                .publicationDate(mobile.getPublicationDate())
					                                .country(country)
					                                .accessoryInfo(accessory)
					                                .build();
			  
			  return Mono.just(finalResponse);
		  });
	}

	public Mono<MobileClientDto> getAllMobileInfo(int id) {
		return mobileServiceIntegration
				.getMobileById(id)
				.flatMap(mobile ->  getAllMobileInfo(mobile));
	}

}
