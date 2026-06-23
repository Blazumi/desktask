package com.blazumi.desktask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazumi.desktask.model.TaskRecipient;

public interface TaskRecipientRepository extends JpaRepository<TaskRecipient, Long>{

}
