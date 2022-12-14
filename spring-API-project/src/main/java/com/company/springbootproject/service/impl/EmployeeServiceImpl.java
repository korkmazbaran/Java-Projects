package com.company.springbootproject.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.company.springbootproject.repository.EmployeeRepository;
import com.company.springbootproject.service.EmployeeService;
import com.company.springbootproject.dto.EmployeeDto;
import com.company.springbootproject.entity.Employee;
import lombok.RequiredArgsConstructor;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelmapper;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository , ModelMapper modelmapper) {
		this.employeeRepository = employeeRepository;
		this.modelmapper = modelmapper;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = modelmapper.map(employeeDto, Employee.class);
		return modelmapper.map(employeeRepository.save(employee), EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> dtos = employees.stream().map(employee -> modelmapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());	
		return dtos;
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employee) {
		Optional<Employee> resultEmployee = employeeRepository.findById(id);
		if (resultEmployee.isPresent()) {
			resultEmployee.get().setName(employee.getName());
			resultEmployee.get().setLastName(employee.getLastName());
			return modelmapper.map(employeeRepository.save(resultEmployee.get()), EmployeeDto.class);
		}
		return null;
	}

	@Override
	public Boolean deleteEmployee(Long id) {
		Optional<Employee> resultEmployee = employeeRepository.findById(id);
		if (resultEmployee.isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
