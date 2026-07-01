package com.blazumi.desktask.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TeamResponse {

	private Long id;
	private String name;
	
	private Long managerId;
	private String managerUsername;
	
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
