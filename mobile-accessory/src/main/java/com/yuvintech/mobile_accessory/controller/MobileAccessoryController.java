package com.yuvintech.mobile_accessory.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuvintech.mobile_accessory.entity.MobileAccessory;
import com.yuvintech.mobile_accessory.repository.MobileAccessoryRepository;
import com.yuvintech.msk.common.dto.MobileAccessoryDto;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("mobile-accessories")
public class MobileAccessoryController {
	
	
	@Autowired
	private MobileAccessoryRepository repostiory;

	
	@PostMapping
	public Flux<MobileAccessoryDto> saveMobileAccessory(@RequestBody MobileAccessory mobileAccessory) {
		UUID id = UUID.randomUUID();
		mobileAccessory.setId(id);
		mobileAccessory.setIsActive(true);
		  return repostiory
		  .save(mobileAccessory)
		  .flatMapMany(data -> getAllAccessories());
	}
	
	@GetMapping
	public Flux<MobileAccessoryDto> getAllAccessories() {
		 Flux<MobileAccessory> allMobilesDetails =  repostiory.findAll();
		 return convertiEntityDto(allMobilesDetails);
	}
	
	
	private Flux<MobileAccessoryDto>  convertiEntityDto(Flux<MobileAccessory> allMobilesDetails ) {
		 return  allMobilesDetails
				 .flatMap(entity ->  Mono.just(convertEntityToDto(entity)));
	}
	
	private MobileAccessoryDto convertEntityToDto(MobileAccessory entity){
		return  MobileAccessoryDto
				 .builder()
				 .id(entity.getId())
				 .description(entity.getDescription())
				 .isActive(entity.getIsActive())
				 .name(entity.getName())
				 .mobileType(entity.getMobileType())
				 .build();
	}
	
	@GetMapping("/{uuid}")
	public Mono<MobileAccessoryDto> getById(@PathVariable UUID uuid){
		return repostiory
				.findById(uuid)
				.map(entity -> convertEntityToDto(entity));
	}
	
	@GetMapping("find/{mobile-type}")
	public Flux<MobileAccessoryDto> getByMobileType(@PathVariable("mobile-type") String mobileType){
		return repostiory
				.findByMobileType(mobileType)
				.map(entity -> convertEntityToDto(entity));
	}
	
	
	@PutMapping("/{uuid}")
	public Mono<MobileAccessoryDto> updateMobileAccessory(@PathVariable UUID uuid, @RequestBody MobileAccessory mobileAccessory){
		
	Mono<MobileAccessory> dbMobileAccessory = repostiory.findById(uuid);
	  return 
			  dbMobileAccessory.flatMap(accessory -> {
			if(null == mobileAccessory)
				throw new RuntimeException("Invalid UUID "+uuid);
			
			mobileAccessory.setId(uuid);
			return repostiory
						   .save(mobileAccessory)
						   .flatMap(data ->  getById(uuid));
						
		});
	  
	}
	
	
	@DeleteMapping("/{uuid}")
	public Mono<String> deletedMobileAccessoryById(@PathVariable UUID uuid){
		Mono<MobileAccessory> dbMobileAccessory = repostiory.findById(uuid);
		return dbMobileAccessory.flatMap(accessory -> {
			
			accessory.setIsActive(false);
			return repostiory
			          .save(accessory)
			          .flatMap(data ->  Mono.just("SuccessFully Deleted"));
			
		});
		
	}
	
	
}
