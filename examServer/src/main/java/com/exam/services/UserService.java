package com.exam.services;

import java.util.Set;

import com.exam.model.User;
import com.exam.model.User_Role;
import com.exam.model.ResponseDTO.UpdateUserResponseDTO;

public interface UserService {

	// creating user
	public User createUser(User user,Set<User_Role> userRoles) throws Exception;
	
	// fetch user using username
	public User getUser(String username);

	
	//Delete user using userId
	public String deleteUser(Long userId);
	
	//update the details of user
	public UpdateUserResponseDTO updateUser(Long userId, User user) throws Exception;
	
	public String changeProfile(String url);

	public User createUserV1(User user);
}
