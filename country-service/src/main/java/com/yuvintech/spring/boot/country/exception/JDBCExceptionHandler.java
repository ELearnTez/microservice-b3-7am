package com.yuvintech.spring.boot.country.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JDBCExceptionHandler {

	
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorDetails> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex){
		
		ErrorDetails error = ErrorDetails.builder().code(10001).message("No Data Found For this Input").build();
		
		return  ResponseEntity.badRequest().body(error);
	}
	
	
}
