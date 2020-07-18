package com.yuvintech.spring.boot.mobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.BAD_REQUEST , reason = "The Mobile Id is Not valid")
public class MobileNotFoundException extends RuntimeException{
	
	public MobileNotFoundException(String message) {
		super(message);
	}

}
