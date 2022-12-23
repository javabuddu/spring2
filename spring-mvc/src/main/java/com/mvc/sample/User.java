package com.mvc.sample;

import javax.validation.constraints.NotEmpty;

public class User {
	
	
	@NotEmpty(message = "Name can not empty")
	private String userName;

	private String userSkill;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSkill() {
		return userSkill;
	}
	public void setUserSkill(String userSkill) {
		this.userSkill = userSkill;
	}
	
	

}
