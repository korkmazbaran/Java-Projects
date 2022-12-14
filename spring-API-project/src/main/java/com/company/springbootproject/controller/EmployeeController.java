package com.company.springbootproject.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springbootproject.dto.EmployeeDto;
import com.company.springbootproject.entity.Employee;
import com.company.springbootproject.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	 @PostMapping("/create")
	 public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employee){
		 EmployeeDto resultEmployee = employeeService.createEmployee(employee);
		 return ResponseEntity.ok(resultEmployee);
	 }
	 @GetMapping("/getAll")
	 public ResponseEntity<List<EmployeeDto>> getEmployees(){
		 List<EmployeeDto> employees = employeeService.getEmployees();
		 return ResponseEntity.ok(employees);
	 }
	 @PutMapping("/edit/{id}")
	 public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeDto employee){
		 EmployeeDto resultEmployee = employeeService.updateEmployee(id,employee);
		 return ResponseEntity.ok(resultEmployee);
	 }
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long id){
		 Boolean status = employeeService.deleteEmployee(id);
		 return ResponseEntity.ok(status);
		 
		 
	 }
	 
}
