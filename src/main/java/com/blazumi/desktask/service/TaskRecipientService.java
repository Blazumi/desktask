package com.blazumi.desktask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blazumi.desktask.model.Task;
import com.blazumi.desktask.model.TaskRecipient;
import com.blazumi.desktask.model.User;
import com.blazumi.desktask.repository.TaskRecipientRepository;

@Service
public class TaskRecipientService {

	private final TaskRecipientRepository taskRecipientRepository;
	private final UserService userService;
	public TaskRecipientService(TaskRecipientRepository taskRecipientRepository, UserService userService) {
		this.taskRecipientRepository = taskRecipientRepository;
		this.userService = userService;
	}
	
	public void addRecipients(Task task, List<Long> userIds) {
		if(userIds == null || userIds.isEmpty()) {
			return;
		}
		for(Long userId : userIds) {
			User user = userService.findUserById(userId);
			
			TaskRecipient recipient = new TaskRecipient();
			recipient.setTask(task);
			recipient.setUser(user);
			taskRecipientRepository.save(recipient);
		}
	}
}
