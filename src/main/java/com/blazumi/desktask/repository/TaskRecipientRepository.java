package com.blazumi.desktask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazumi.desktask.model.TaskRecipient;

public interface TaskRecipientRepository extends JpaRepository<TaskRecipient, Long>{

	List<TaskRecipient> findByUserId(Long userId);
}
