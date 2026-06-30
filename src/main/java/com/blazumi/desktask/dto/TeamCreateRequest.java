package com.blazumi.desktask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TeamCreateRequest {

	@NotBlank(message = "team 名稱不可為空")
	@Size(max = 100, message = "team 名稱不可超過100字")
	private String name;
	
	@NotNull(message = "managerId 不能為空")
	private Long managerId;
}
