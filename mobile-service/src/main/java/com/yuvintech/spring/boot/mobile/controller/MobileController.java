package com.yuvintech.spring.boot.mobile.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

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

import com.yuvintech.msk.common.dto.FilterDto;
import com.yuvintech.msk.common.dto.MobileDto;
import com.yuvintech.msk.common.dto.Response;
import com.yuvintech.msk.common.dto.SaveMobileDto;
import com.yuvintech.spring.boot.mobile.aop.LogExecutionTime;
import com.yuvintech.spring.boot.mobile.service.MobileService;
import com.yuvintech.spring.boot.mobile.service.ThreadLocalUtil;
import com.yuvintech.spring.boot.mobile.util.ValidatorUtil;

@RestController
@RequestMapping("/mobiles")
public class MobileController {
	
	
	@Autowired
	private MobileService mobileService;
	
	@LogExecutionTime
	@GetMapping	
	public Response<List<MobileDto>> getAllMobileDtos(FilterDto filterDto){		
		return mobileService.getAllMobiles(filterDto);
	}
	
	
	@LogExecutionTime
	@GetMapping(value = "/{mobile-id}")
	public Response<MobileDto> getMobileDtoById(@PathVariable("mobile-id") int mobileId) {
	
		System.out.println(mobileId+" SUNILMANAKA "+Thread.currentThread().getName());
		ThreadLocalUtil.setData(mobileId+" SUNILMANAKA "+ Thread.currentThread().getName());
		Response<MobileDto> response =  mobileService.getMobileById(mobileId);
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(ThreadLocalUtil.getData()+" SUNILMANAKA "+Thread.currentThread().getName());
		
		return response;
		
		
	}
	
	
	@LogExecutionTime
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Response<List<MobileDto>> saveMobileDto(@RequestBody @Valid SaveMobileDto saveMobieDto){
		ValidatorUtil.valdate(saveMobieDto);
		return mobileService.saveMobile(saveMobieDto);
	}
	
	@LogExecutionTime
	@PutMapping("/{mobile-id}")
	public Response<MobileDto> updateMobileDto(@RequestBody MobileDto mobileDto, @PathVariable("mobile-id") int mobileId) {
		return mobileService.updateMobile(mobileDto, mobileId);
	}
	
	@LogExecutionTime
	@DeleteMapping("/{mobile-id}")
	@ResponseStatus(value= HttpStatus.ACCEPTED)
	public Response<Void> deleteMobileDto(@PathVariable("mobile-id") int mobileId) {
		return mobileService.deleteMobile(mobileId);
	}
	
	
	
	
	
	/*@ExceptionHandler(value = MobileDtoNotFoundException.class)
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorDetails> handleMobileDtoNotFoundException(MobileDtoNotFoundException ex) {
		
		ErrorDetails errorDetails= new ErrorDetails(1001 , ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
	}*/

}
