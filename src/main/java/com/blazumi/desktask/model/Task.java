package com.blazumi.desktask.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.blazumi.desktask.enums.TaskPriority;
import com.blazumi.desktask.enums.TaskStatus;
import com.blazumi.desktask.enums.TaskType;
import com.blazumi.desktask.enums.Visibility;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
@EntityListeners(AuditingEntityListener.class)
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
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TaskPriority priority = TaskPriority.NORMAL;
	
	private LocalDateTime dueTime;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user;
	
	@CreatedDate
	@Column(updatable = false, nullable = false)
	private LocalDateTime createAt;
	
	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime updateAt;
	
	@Version
	private Long version;
	
	
	
}
