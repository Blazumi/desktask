package com.blazumi.desktask.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.blazumi.desktask.enums.TaskStatus;
import com.blazumi.desktask.enums.TaskType;
import com.blazumi.desktask.enums.Visibility;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskCreateRequest {
	
	@NotBlank(message = "任務標題不可為空")
	@Size(max = 200, message = "任務標題不可超過 200 字")
	private String title;
	
	@Size(max = 1000, message = "任務描述不可超過 1000 字")
	private String description;
	
    @NotNull(message = "任務狀態不可為空")
    private TaskStatus status;

    @NotNull(message = "任務類型不可為空")
    private TaskType taskType;

    @NotNull(message = "任務可見性不可為空")
    private Visibility visibility;

    @NotNull(message = "到期時間不可為空")
    private LocalDateTime dueTime;
    
    @NotNull(message = "使用者ID不可為空")
    private Long userId;
    
    private List<Long> recipientUserIds;
}
