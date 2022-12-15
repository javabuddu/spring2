package com.spring.rest.jpa.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmployeeBean {
	
	private long id;
	private String name;
	private String lastname;
	private String designation;
	private int phone;
	private String email;

}
