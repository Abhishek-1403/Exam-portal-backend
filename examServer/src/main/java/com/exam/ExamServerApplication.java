package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.User_Role;
import com.exam.services.UserService;

@SpringBootApplication()
public class ExamServerApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
		
		
		
	}
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("**************************************************************************");
		System.out.println("************************                        **************************");
		System.out.println("************             EXAM PORTAL APPLICATION             *************");
		System.out.println("************************                        **************************");
		System.out.println("**************************************************************************");
	
//		User user = new User();
//		user.setFirstName("Abhishek");
//		user.setLastName("Gupta");
//		user.setUsername("abhi_1234");
//		user.setPassword("1234");
//		user.setEmail("tempmail@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		
//		
//		Set<User_Role> userRoles= new HashSet<>();
//		User_Role userRole = new User_Role();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		
//		userRoles.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRoles);
//		System.out.println(user1.getUsername());
		
	
	
	}

}
