package com.yuvintech.mobile.service.functional.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yuvintech.mobile.service.functional.dto.SaveMobileDto;

@RestController
public class TestController {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveMobileDto(@RequestBody @Valid SaveMobileDto saveMobieDto){
		System.out.println(saveMobieDto);
	}
	
}
