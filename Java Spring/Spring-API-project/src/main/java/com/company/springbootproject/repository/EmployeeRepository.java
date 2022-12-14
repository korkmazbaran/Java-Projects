package com.company.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.springbootproject.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
