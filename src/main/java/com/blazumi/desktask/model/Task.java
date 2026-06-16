package com.blazumi.desktask.model;

import java.time.LocalDateTime;

import com.blazumi.desktask.enums.TaskStatus;
import com.blazumi.desktask.enums.TaskType;
import com.blazumi.desktask.enums.Visibility;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String title;
	
	@Column(length = 1000)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
   	private TaskStatus status;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TaskType taskType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Visibility visibility;
	
	@Column(nullable = false)
	private LocalDateTime dueTime;
	
	
}
