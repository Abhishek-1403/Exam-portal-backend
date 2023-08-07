package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.User_Role;
import com.exam.model.ResponseDTO.UpdateUserResponseDTO;
import com.exam.services.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		
		Set<User_Role> roles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		User_Role userRole = new User_Role();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		
		return this.userService.createUser(user,roles);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable("userId") Long userId) {
		 
		return this.userService.deleteUser(userId);
		
	}
	
	
	@PutMapping("/{userId}")
	public UpdateUserResponseDTO updateUser(@PathVariable("userId") Long userId,@RequestBody User user) throws Exception {
		return this.userService.updateUser(userId,user);
	}
	
	@PostMapping("/create")
	public User createUserV1(@RequestBody User user) {
		return this.userService.createUserV1(user);
	}
	
}
