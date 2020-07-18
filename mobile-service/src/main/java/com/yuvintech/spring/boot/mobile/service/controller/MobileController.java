package com.yuvintech.spring.boot.mobile.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yuvintech.spring.boot.mobile.service.MobileService;
import com.yuvintech.spring.boot.mobile.service.data.Mobile;

@RestController
@RequestMapping("/mobile")
public class MobileController {
	
	
	@Autowired
	private MobileService mobileService;
	
	

	@GetMapping	
	public List<Mobile> getAllMobiles(){
		return mobileService.getAllMobiles();
	}
	
	@GetMapping(value = "/{mobile-id}", produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
			})
	public Mobile getMobileById(@PathVariable("mobile-id") int mobileId) {
	 return mobileService.getMobileById(mobileId);
	}
	
	@PostMapping
	public ResponseEntity<List<Mobile>> saveMobile(HttpEntity<Mobile> he){
		
		Mobile request = he.getBody();
		
		HttpHeaders headers =  he.getHeaders();
		
		headers.forEach((k, v) -> {
			System.out.println("Key : "+k);
			System.out.println("value : "+v);
		});
		
		return ResponseEntity.status(1001).body(mobileService.saveMobile(request));
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
	
	
	@GetMapping("/hi")
	public String sayHello() {
		return "Welcome to Spring Boot Controller. You can't see this message on screen.";			
				
	}
	
	
	/*@ExceptionHandler(value = MobileNotFoundException.class)
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorDetails> handleMobileNotFoundException(MobileNotFoundException ex) {
		
		ErrorDetails errorDetails= new ErrorDetails(1001 , ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
	}*/

}
