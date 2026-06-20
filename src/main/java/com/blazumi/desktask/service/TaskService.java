package com.blazumi.desktask.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.blazumi.desktask.exception.BusinessException;
import com.blazumi.desktask.model.Task;
import com.blazumi.desktask.repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> findAllTasks(){
		return taskRepository.findAll();
	}
	
	public Task findTaskById(Long id){

		return taskRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Id:" + id + "查無此任務"));
	}
	
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task updateTask(Long id, Task task) {
		Task orgTask = findTaskById(id);
		
		orgTask.setTitle(task.getTitle());
		orgTask.setDescription(task.getDescription());
		orgTask.setStatus(task.getStatus());
		orgTask.setTaskType(task.getTaskType());
		orgTask.setVisibility(task.getVisibility());
		orgTask.setDueTime(task.getDueTime());
		return taskRepository.save(orgTask);
	}
	
	public void deleteTask(Long id) {
		Task task = findTaskById(id);
		taskRepository.delete(task);
	}
	
	
	
	
}
