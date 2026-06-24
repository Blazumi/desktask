package com.blazumi.desktask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blazumi.desktask.exception.BusinessException;
import com.blazumi.desktask.model.User;
import com.blazumi.desktask.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User findUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new BusinessException("Id:" + id + "查無此使用者")); 
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(Long id, User user) {
		User orgUser = findUserById(id);
		
		orgUser.setUsername(user.getUsername());
		orgUser.setEmail(user.getEmail());
		orgUser.setRole(user.getRole());
		
		return userRepository.save(orgUser);
		
	}
	
	public User updateUserPassword(Long id, String password) {
		User orgUser = findUserById(id);
		orgUser.setPassword(password);
		return userRepository.save(orgUser);
	}
	
	public void deleteUser(Long id) {
		User user = findUserById(id);
		userRepository.delete(user);
	}
}
