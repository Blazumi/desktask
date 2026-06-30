package com.blazumi.desktask.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TeamMemberAddRequest {

	@NotNull(message = "userId 不可為空")
	private Long userId;
}
