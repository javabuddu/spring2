package com.spring.rest.jpa.service;

import java.util.Map;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.jpa.dto.EmployeeBean;
import com.spring.rest.jpa.entity.Employee;
import com.spring.rest.jpa.exception.IdNotFoundException;
import com.spring.rest.jpa.repository.EmployeeRepository;
import com.spring.rest.jpa.util.Util;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeBean save(EmployeeBean emp) {
		System.out.println("this is in service impl ");
		Employee empEntity = Util.dtoToEntity(emp);
		// Employee emp1=employeeRepository.save(empEntity);
		emp = Util.entityToDto(employeeRepository.save(empEntity));
		return emp;
	}

	@Override
	public EmployeeBean getById(long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeBean findEmpId(long id) throws IdNotFoundException {
		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Employee Id Not Found!!!" + id));
		return Util.entityToDto(emp);
	}

	@Override
	public EmployeeBean updateEmp(EmployeeBean isExist) {
		Employee empEntity = Util.dtoToEntity(isExist);
		isExist = Util.entityToDto(employeeRepository.save(empEntity));
		// employeeRepository.deleteEmp(id)
		return isExist;
	}

	@Override
	public int deleteemp(long id) {
		int count=employeeRepository.deleteEmp(id);
		return count;
	}

	
	@Override
	public EmployeeBean saveEmp(EmployeeBean empBean) {
		Employee emp=new Employee();
		
		return	Util.entityToDto(employeeRepository.save(emp));
			
			}

	@Override
	public Employee patch(long id) {
		Employee emp=null;
		Optional<Employee> optionalEmp = employeeRepository.findById(id);
		if(optionalEmp.isPresent()) {
			emp= optionalEmp.get();
			
		}
				
		return emp;
	}

	@Override
	public Employee savePatchEmp(Employee empBean) {
		// TODO Auto-generated method stub
		return employeeRepository.save(empBean);
	}

	
		}

	

	

	


