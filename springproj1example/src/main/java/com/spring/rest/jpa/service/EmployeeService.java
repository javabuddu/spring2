package com.spring.rest.jpa.service;

import java.util.Map;

import com.spring.rest.jpa.dto.EmployeeBean;
import com.spring.rest.jpa.entity.Employee;
import com.spring.rest.jpa.exception.IdNotFoundException;

public interface EmployeeService {

	
	public EmployeeBean getById(long Id);

	public EmployeeBean findEmpId(long id) throws IdNotFoundException;

	public EmployeeBean updateEmp(EmployeeBean isExist);

	public int deleteemp(long id);
	EmployeeBean save(EmployeeBean emp);

	public EmployeeBean saveEmp(EmployeeBean empBean);

	public Employee patch(long id);

	public Employee savePatchEmp(Employee empBean);

	

	

	
}