package com.spring.rest.jpa.util;

import java.util.List;

import com.spring.rest.jpa.dto.EmployeeBean;
import com.spring.rest.jpa.entity.Employee;


public class Util {
	
	public static Employee dtoToEntity(EmployeeBean dto) { // input parameter EmployeeBean, return Employee entity
		Employee entity=new Employee();
		entity.setDesignation(dto.getDesignation());
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getName());
		entity.setLastName(dto.getLastname());
		entity.setMobileNumber(dto.getPhone());
		entity.setId(dto.getId());
		return entity;
		
	}

	public static EmployeeBean entityToDto(Employee empEntity) {
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setId(empEntity.getId());
		employeeBean.setName(empEntity.getFirstName());
		employeeBean.setDesignation(empEntity.getDesignation());
		employeeBean.setEmail(empEntity.getEmail());
		employeeBean.setName(empEntity.getFirstName());
		employeeBean.setLastname(empEntity.getLastName());
		employeeBean.setPhone(empEntity.getMobileNumber());
		return employeeBean;
	}


	

}
