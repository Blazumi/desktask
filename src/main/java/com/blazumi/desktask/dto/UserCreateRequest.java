
package com.blazumi.desktask.dto;

import com.blazumi.desktask.enums.UserRole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {
	@NotBlank(message = "使用者名稱不可為空")
	@Size(max = 50, message = "使用者名稱不可超過50字")
	private String username;
	
	@NotBlank(message = "電子郵箱不可為空")
	@Size(max = 50, message = "電子郵箱不可超過50字")
	private String email;
	
	@NotBlank(message = "使用者密碼不可為空")
	@Size(min = 6, max = 100, message = "使用者密碼最少6個字，最多100字")
	private String password;
	
	@NotNull(message = "角色不可為空")
	private UserRole role;
}
