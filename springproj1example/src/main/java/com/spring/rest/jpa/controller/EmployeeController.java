package com.spring.rest.jpa.controller;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.jpa.dto.EmployeeBean;
import com.spring.rest.jpa.entity.Employee;
import com.spring.rest.jpa.exception.EmployeeDtlsNotFoundException;
import com.spring.rest.jpa.exception.IdNotFoundException;
import com.spring.rest.jpa.service.EmployeeService;

@RestController
@RequestMapping("/emp") // class level
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/saveemp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) // it
																																// is																															// used
																																// to
																																// save
																																// or
																																// create
																																// new
																																// resource
																																// /object
																																// at
																																// service																															// level
	public ResponseEntity<?> saveEmp(@RequestBody EmployeeBean emp) {
		emp = employeeService.save(emp);
		return ResponseEntity.ok().body(emp);// http status code =200 , 201
	}

	@RequestMapping(value = "/updateemp", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeBean updateEmp(@RequestBody EmployeeBean emp) throws IdNotFoundException {
		EmployeeBean isExist = null;
		if (emp.getId() == 0) {
			throw new EmployeeDtlsNotFoundException("Please enter employee details!!!");
		} else {
			isExist = employeeService.findEmpId(emp.getId());
			isExist.setDesignation(emp.getDesignation());
			isExist.setEmail(emp.getEmail());
			isExist.setLastname(emp.getLastname());
			isExist.setName(emp.getName());
			isExist.setPhone(emp.getPhone());
			isExist = employeeService.updateEmp(isExist);
		}
		return isExist;
	}

	@DeleteMapping(value = "/deleteemp/{id}")
	 public String deleteemp(@PathVariable("id") long id)
	 { 
	  int count=employeeService.deleteemp(id);
       return "deleted "+count+" record";
	 }
	@PatchMapping(value = "/partialupdate/{id}")
	public Employee partialUpdate(@PathVariable("id") long id,@RequestBody Map<String, Object> changes)
	
	{  
		
		Employee empBean =employeeService.patch(id);
		changes.forEach(
                (k, value) -> {
					
					/*
					 * switch (k){ case "name": empBean.setName((String) value); break; case
					 * "lastName": empBean.setLastname((String) value); break; case "eamil":
					 * empBean.setEmail((String) value); break; case "phone":
					 * empBean.setPhone((Integer) value);break; case
					 * "designation":empBean.setDesignation((String) value);break; }
					 */
                
		Field field = ReflectionUtils.findRequiredField(Employee.class,k);
        field.setAccessible(true);
        ReflectionUtils.setField(field, empBean, value);
                });
		
		Employee empBean2= employeeService.savePatchEmp(empBean);
		 return empBean2;
		
		
	}
	


	 
	
	

	/*
	 * @ExceptionHandler(EmployeeDtlsNotFoundException.class) public
	 * ResponseEntity<Object> exception(EmployeeDtlsNotFoundException exception) {
	 * return new ResponseEntity<>("Employee not found :: " +
	 * exception.getMessage(), HttpStatus.BAD_REQUEST); }
	 */

}

