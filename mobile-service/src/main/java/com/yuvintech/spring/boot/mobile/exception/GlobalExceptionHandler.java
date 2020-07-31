package com.yuvintech.spring.boot.mobile.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.yuvintech.msk.common.dto.ErrorDetails;
import com.yuvintech.msk.common.dto.Response;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value = MobileNotFoundException.class)
	public ResponseEntity<Response<ErrorDetails>> handleMobileNotFoundException(MobileNotFoundException ex) {
		ErrorDetails errorDetails = ErrorDetails.builder().code(1011).message(ex.getMessage()).build();		
		Response<ErrorDetails>  response =  Response.<ErrorDetails>builder().errors(Arrays.asList(errorDetails)).build();
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body( response);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Response<ErrorDetails>> handleNullpiointerException(NullPointerException npe) {
		//npe.printStackTrace();
		ErrorDetails errorDetails = buildErrorDetails(npe,  1010);		
		Response<ErrorDetails>  response =  Response.<ErrorDetails>builder().errors(Arrays.asList(errorDetails)).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	
	
	@ExceptionHandler(value = InvalidInputException.class)
	public ResponseEntity<Response<List<ErrorDetails>>>  handleInvalidInputException(InvalidInputException ex) {
		
		Response<List<ErrorDetails>> response =  Response.<List<ErrorDetails>>builder().errors(ex.getErrors()).build();
		
		return  ResponseEntity.badRequest().body(response);
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Response<List<ErrorDetails>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		BindingResult bindingResult =ex.getBindingResult();
		
	List<ErrorDetails> validationErrors = 	bindingResult.
			getAllErrors().
			stream().
			map(error -> ErrorDetails.builder().code(1010).message( error.getDefaultMessage()).build())
			.collect(Collectors.toList());
	Response<List<ErrorDetails>> response =  Response.<List<ErrorDetails>>builder().errors(validationErrors).build();
	
	
		return ResponseEntity.badRequest().body(response);
		
	}
	
	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<Response<ErrorDetails>>  handleThrowable(Throwable th) {
		th.printStackTrace();
		ErrorDetails errorDetails = buildErrorDetails(th, 1020);	
		Response<ErrorDetails> response =  Response.<ErrorDetails>builder().errors(Arrays.asList(errorDetails)).build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
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
					//.exceptionStackTrace(exceptionStacktrace)
					.build();
	}
	
	
	
}
