package com.company.springbootproject.service;

import java.util.List;

import com.company.springbootproject.dto.EmployeeDto;
import com.company.springbootproject.entity.Employee;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employee);
	List<EmployeeDto> getEmployees();
	EmployeeDto updateEmployee(Long id,EmployeeDto employee);
	Boolean deleteEmployee(Long id);
}
