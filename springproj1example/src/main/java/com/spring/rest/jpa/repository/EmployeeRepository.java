package com.spring.rest.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.jpa.dto.EmployeeBean;
import com.spring.rest.jpa.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "delete from employee as e where e.id = :id",nativeQuery = true)
	public int deleteEmp(@Param(value = "id") long id);
	
	
	@Query(value="select * from employee",nativeQuery = true)
	public List<Employee> getAllEmployee();



}
