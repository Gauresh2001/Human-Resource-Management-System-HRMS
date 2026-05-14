package com.hrms.service;

import com.hrms.entity.Employee;

import java.util.List;

import com.hrms.dto.request.EmployeeRequestDto;


public interface EmployeeService {

	   Employee addEmployee(EmployeeRequestDto dto);

	    List<Employee> getAllEmployees();

	    Employee getEmployeeById(Long id);

	    Employee updateEmployee(Long id, EmployeeRequestDto dto);

	    void deleteEmployee(Long id);
}
