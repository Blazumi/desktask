package com.blazumi.desktask.dto;

import java.time.LocalDateTime;

import com.blazumi.desktask.enums.TaskStatus;
import com.blazumi.desktask.enums.TaskType;
import com.blazumi.desktask.enums.Visibility;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskUpdateRequest {
	
	@NotBlank(message = "任務標題不可為空")
	@Size(max = 200, message = "任務標題不可超過 200 字")
	private String title;
	
	@NotBlank(message = "任務描述不可為空")
	@Size(max = 200, message = "任務描述不可超過 200 字")
	private String description;
	
	@NotBlank(message = "任務狀態不可為空")
	private TaskStatus status;
	
	@NotBlank(message = "任務類型不可為空")
	private TaskType taskType;
	
	@NotBlank(message = "任務可見性不可為空")
	private Visibility visibility;
	
	@NotBlank(message = "任務期限不可為空")
	private LocalDateTime dueTime;
}
