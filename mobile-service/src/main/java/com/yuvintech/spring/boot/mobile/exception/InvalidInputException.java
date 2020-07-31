package com.yuvintech.spring.boot.mobile.exception;

import java.util.List;

import com.yuvintech.msk.common.dto.ErrorDetails;

public class InvalidInputException extends RuntimeException{

	private List<ErrorDetails> errors;
	
	public InvalidInputException(String message, List<ErrorDetails> errors) {
		super(message);
		this.errors = errors;
	}

	public List<ErrorDetails> getErrors() {
		return errors;
	}

	
	
	
}
