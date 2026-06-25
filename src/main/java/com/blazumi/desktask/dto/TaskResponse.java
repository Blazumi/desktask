package com.blazumi.desktask.dto;

import java.time.LocalDateTime;

import com.blazumi.desktask.enums.TaskPriority;
import com.blazumi.desktask.enums.TaskStatus;
import com.blazumi.desktask.enums.TaskType;
import com.blazumi.desktask.enums.Visibility;

import lombok.Data;

@Data
public class TaskResponse {

	private Long id;
	private String title;
	private String description;
	private TaskStatus status;
	private TaskPriority priority;
	private TaskType taskType;
	private Visibility visibility;
	private LocalDateTime dueTime;
	private Long userId;
	private String username;
	private LocalDateTime creatAt;
	private LocalDateTime updateAt;
	private Long version;
}
