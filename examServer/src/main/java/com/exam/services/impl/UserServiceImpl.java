package com.exam.services.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;
import com.exam.model.User;
import com.exam.model.User_Role;
import com.exam.model.ResponseDTO.UpdateUserResponseDTO;
import com.exam.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	//create User
	@Override
	public User createUser(User user, Set<User_Role> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		
		if(local !=null) {
			System.out.println("User is already exist..");
			throw new Exception("User alredy present !!");
		}
		else {
			//user create
			for(User_Role ur:userRoles) {
				this.roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		
		return local;
	}

	@Override
	public User getUser(String username) {
		
		User user = this.userRepository.findByUsername(username);
		
		if(user != null) {
			return user;
		}
		
		return null;
	}

	@Override
	public String deleteUser(Long userId) {
		
	    this.userRepository.deleteById(userId);
	    
	    Optional<User> user =this.userRepository.findById(userId);
	    
	    if(user.isPresent()) {
	    	return "faild..";
	    }
	    else {
	    	return "success";
	    }
	}

	@Override
	public UpdateUserResponseDTO updateUser(Long userId, User user) throws Exception {
		
		User fetchedUser = this.userRepository.findById(userId).get();
		if(fetchedUser !=null) {
			fetchedUser.setEmail(user.getEmail());
			fetchedUser.setPhone(user.getPhone());
			fetchedUser.setFirstName(user.getFirstName());
			fetchedUser.setLastName(user.getLastName());
			fetchedUser.setProfile(user.getProfile());
			fetchedUser.setEnabled(true);
			
			
			fetchedUser = this.userRepository.save(fetchedUser);
			
			UpdateUserResponseDTO returnData = new UpdateUserResponseDTO();
			
			returnData.setEmail(fetchedUser.getEmail());
			returnData.setPhone(fetchedUser.getPhone());
			returnData.setFirstName(fetchedUser.getFirstName());
			returnData.setLastName(fetchedUser.getLastName());
			returnData.setProfile(fetchedUser.getProfile());
			returnData.setUsername(fetchedUser.getUsername());
			return returnData;
		}
		else {
			throw new Exception("User does not exist which trying to update !!");
		}
	}

	@Override
	public String changeProfile(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUserV1(User user) {
		// TODO Auto-generated method stub
		User user1 = this.userRepository.findByUsername(user.getUsername());
		if(user1 !=null) {
			System.out.println("User already exist..");
		}
		return this.userRepository.save(user);
	}
	
}
