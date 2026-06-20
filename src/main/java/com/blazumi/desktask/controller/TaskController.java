package com.blazumi.desktask.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blazumi.desktask.dto.TaskCreateRequest;
import com.blazumi.desktask.dto.TaskResponse;
import com.blazumi.desktask.dto.TaskUpdateRequest;
import com.blazumi.desktask.model.Task;
import com.blazumi.desktask.response.ApiResponse;
import com.blazumi.desktask.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class TaskController {
	private final TaskService taskService;
	
	public TaskController (TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("/tasks")
	public ApiResponse<List<TaskResponse>> findAllTasks() {
		List<Task> findAllTask = taskService.findAllTasks();
		return ApiResponse.success("查詢訊息成功", toResponse(findAllTask));
	}
	
	@GetMapping("/tasks/{id}")
	public ApiResponse<TaskResponse> findTaskById(@PathVariable Long id) {
		Task findTaskById = taskService.findTaskById(id);
		return ApiResponse.success("查詢ID" + id +"成功：", toResponse(findTaskById));
	}
	
	@PostMapping("/tasks")
	public ApiResponse<TaskResponse> addTask(@Valid @RequestBody TaskCreateRequest request){
		Task task = new Task();
		task.setTitle(request.getTitle());
		task.setDescription(request.getDescription());
		task.setStatus(request.getStatus());
		task.setTaskType(request.getTaskType());
		task.setVisibility(request.getVisibility());
		task.setDueTime(request.getDueTime());
		Task saveTask = taskService.addTask(task);
		return ApiResponse.success("添加任務成功", toResponse(saveTask));
	}
	
	@PutMapping("/tasks/{id}")
	public ApiResponse<TaskResponse> updateTask(@Valid @PathVariable Long id, @RequestBody TaskUpdateRequest request) {
		Task task = new Task();
		task.setTitle(request.getTitle());
		task.setDescription(request.getDescription());
		task.setStatus(request.getStatus());
		task.setTaskType(request.getTaskType());
		task.setVisibility(request.getVisibility());
		task.setDueTime(request.getDueTime());
		
		Task updateTask = taskService.updateTask(id, task);
		return ApiResponse.success("修改成功", toResponse(updateTask));
	}
	
	@DeleteMapping("/tasks/{id}")
	public ApiResponse<Void> deleteTask(@PathVariable Long id){
		taskService.deleteTask(id);
		return ApiResponse.success("刪除成功", null);
	}
	
	private TaskResponse toResponse(Task task) {
		TaskResponse response = new TaskResponse();
		
		response.setId(task.getId());
		response.setTitle(task.getTitle());
		response.setDescription(task.getDescription());
		response.setStatus(task.getStatus());
		response.setTaskType(task.getTaskType());
		response.setVisibility(task.getVisibility());
		response.setDueTime(task.getDueTime());
		return response;
	}
	
	private List<TaskResponse> toResponse(List<Task> tasks) {
		List<TaskResponse> responses = new ArrayList<>();
		for(Task task : tasks) {
			responses.add(toResponse(task));
		}
		
		return responses;
	}
}
