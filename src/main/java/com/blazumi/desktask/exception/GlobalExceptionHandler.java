package com.blazumi.desktask.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blazumi.desktask.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiResponse<String>> handleBusinessException(BusinessException e){
		return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
		
	}
	
}
