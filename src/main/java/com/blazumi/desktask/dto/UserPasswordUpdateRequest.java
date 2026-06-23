package com.blazumi.desktask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserPasswordUpdateRequest {
	
	@NotBlank(message = "密碼不可為空")
	@Size(min = 6, max = 100, message = "使用者密碼不可超過50字")
	private String password;
}
