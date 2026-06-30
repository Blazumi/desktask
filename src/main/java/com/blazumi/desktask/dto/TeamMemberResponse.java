package com.blazumi.desktask.dto;

import java.time.LocalDateTime;

import com.blazumi.desktask.enums.UserRole;

import lombok.Data;

@Data
public class TeamMemberResponse {

	private Long id;
	
	private Long teamId;
	private String teamName;
	
	private Long userId;
	private String username;
	private String email;
	private UserRole role;
	
	private LocalDateTime joinedAt;
}
