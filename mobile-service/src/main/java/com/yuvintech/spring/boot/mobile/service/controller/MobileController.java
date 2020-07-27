package com.yuvintech.spring.boot.mobile.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yuvintech.spring.boot.mobile.dto.FilterDto;
import com.yuvintech.spring.boot.mobile.entity.Mobile;
import com.yuvintech.spring.boot.mobile.service.MobileService;

@RestController
@RequestMapping("/mobiles")
public class MobileController {
	
	
	@Autowired
	private MobileService mobileService;
	
	@GetMapping	
	public List<Mobile> getAllMobiles(FilterDto filterDto){		
		return mobileService.getAllMobiles(filterDto);
	}
	
	@GetMapping(value = "/{mobile-id}")
	public Mobile getMobileById(@PathVariable("mobile-id") int mobileId) {
	 return mobileService.getMobileById(mobileId);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Mobile> saveMobile(@RequestBody Mobile mobile){
		return mobileService.saveMobile(mobile);
	}
	
	
	@PutMapping("/{mobile-id}")
	public Mobile updateMobile(@RequestBody Mobile mobile, @PathVariable("mobile-id") int mobileId) {
		return mobileService.updateMobile(mobile, mobileId);
	}
	
	@DeleteMapping("/{mobile-id}")
	@ResponseStatus(value= HttpStatus.ACCEPTED)
	public void deleteMobile(@PathVariable("mobile-id") int mobileId) {
		mobileService.deleteMobile(mobileId);
	}
	
	
	
	
	
	/*@ExceptionHandler(value = MobileNotFoundException.class)
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorDetails> handleMobileNotFoundException(MobileNotFoundException ex) {
		
		ErrorDetails errorDetails= new ErrorDetails(1001 , ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
	}*/

}
