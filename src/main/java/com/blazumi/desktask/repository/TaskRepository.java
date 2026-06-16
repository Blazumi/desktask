package com.blazumi.desktask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazumi.desktask.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
