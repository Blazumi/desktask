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

import com.blazumi.desktask.dto.UserCreateRequest;
import com.blazumi.desktask.dto.UserPasswordUpdateRequest;
import com.blazumi.desktask.dto.UserResponse;
import com.blazumi.desktask.dto.UserUpdateRequest;
import com.blazumi.desktask.model.User;
import com.blazumi.desktask.response.ApiResponse;
import com.blazumi.desktask.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public ApiResponse<List<UserResponse>> findAllUsers(){
		List<User> users = userService.findAllUsers(); 
		return ApiResponse.success("查詢所有使用者成功", toResponse(users));
	}
	
	@GetMapping("/users/{id}")
	public ApiResponse<UserResponse> findUserById(@PathVariable Long id){
		User user = userService.findUserById(id);
		return ApiResponse.success("查詢ID:" + id + "成功", toResponse(user));		
	}
	
	@PostMapping("/users")
	public ApiResponse<UserResponse> addUser(@Valid @RequestBody UserCreateRequest request){
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setEmail(request.getEmail());
		user.setRole(request.getRole());
		User saveUser = userService.addUser(user);
		return ApiResponse.success("添加使用者成功", toResponse(saveUser));
	}
	
	@PutMapping("/users/{id}")
	public ApiResponse<UserResponse> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest request){
		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setRole(request.getRole());
		User updateUser = userService.updateUser(id, user);
		return ApiResponse.success("修改使用者成功", toResponse(updateUser));
	}
	
	@PutMapping("/users/{id}/password")
	public ApiResponse<UserResponse> updateUserPassword(@PathVariable Long id, @Valid @RequestBody UserPasswordUpdateRequest request) {

		User updatePassword = userService.updateUserPassword(id, request.getPassword());
		return ApiResponse.success("修改密碼成功", toResponse(updatePassword));
	}
	
	@DeleteMapping("/users/{id}")
	public ApiResponse<Void> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return ApiResponse.success("刪除使用者成功", null);
	}
	
	public UserResponse toResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setUsername(user.getUsername());
		userResponse.setEmail(user.getEmail());
		userResponse.setRole(user.getRole());
		
		return userResponse;
	}
	
	public List<UserResponse> toResponse(List<User> users){
		List<UserResponse> userResponses = new ArrayList<>();
		for(User user : users) {
			userResponses.add(toResponse(user));
		}
		return userResponses;
	}
}
