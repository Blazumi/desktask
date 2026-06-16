package com.blazumi.desktask.exception;

public class BusinessException extends RuntimeException{
	public BusinessException(String errorMessage) {
		super(errorMessage);
	}

}
