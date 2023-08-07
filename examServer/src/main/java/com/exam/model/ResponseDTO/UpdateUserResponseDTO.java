package com.exam.model.ResponseDTO;




public class UpdateUserResponseDTO {
	
	
	private String username;
	private  String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String profile;
	
	
	
	public UpdateUserResponseDTO() {
		super();
	}
	public UpdateUserResponseDTO(String username, String firstName, String lastName, String phone, String email,
			String profile) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.profile = profile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
}
