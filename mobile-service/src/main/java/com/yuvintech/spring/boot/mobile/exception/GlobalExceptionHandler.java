package com.yuvintech.spring.boot.mobile.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value = MobileNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleMobileNotFoundException(MobileNotFoundException ex) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body( ErrorDetails
						.builder()
						.code(1011)
						.message(ex.getMessage())
						.build()
					);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ErrorDetails> handleNullpiointerException(NullPointerException npe) {
		npe.printStackTrace();
		ErrorDetails errorDetails = buildErrorDetails(npe,  1010);		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
	}
	
	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<ErrorDetails> handleThrowable(Throwable th) {
		th.printStackTrace();
		ErrorDetails errorDetails = buildErrorDetails(th, 1020);	
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
	}
	
	private ErrorDetails buildErrorDetails(Throwable th, int errorCode) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		th.printStackTrace(pw);		
		String exceptionStacktrace = sw.toString();
		
		return ErrorDetails
					.builder()
					.code(errorCode)
					.message(th.getMessage())
					.exceptionStackTrace(exceptionStacktrace)
					.build();
	}
	
	
	
}
