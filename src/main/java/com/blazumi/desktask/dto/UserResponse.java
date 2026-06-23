package com.blazumi.desktask.dto;

import com.blazumi.desktask.enums.UserRole;

import lombok.Data;

@Data
public class UserResponse {
	
	private Long id;
	private String username;
	private String email;
	private UserRole role;
	
}
