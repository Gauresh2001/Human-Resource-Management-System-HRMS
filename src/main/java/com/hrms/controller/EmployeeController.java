package com.hrms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hrms.entity.Employee;
import com.hrms.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // =========================
    // GET ALL EMPLOYEES
    // =========================
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    // =========================
    // GET EMPLOYEE BY ID
    // =========================
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));
    }

    // =========================
    // ADD EMPLOYEE
    // =========================
    @PostMapping("/add")
    public Employee addEmployee(
            @RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    // =========================
    // UPDATE EMPLOYEE
    // =========================
    @PutMapping("/update/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee updatedEmployee) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Employee not found"));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPhone(updatedEmployee.getPhone());
        employee.setAddress(updatedEmployee.getAddress());
        employee.setSalary(updatedEmployee.getSalary());

        return employeeRepository.save(employee);
    }

    // =========================
    // DELETE EMPLOYEE
    // =========================
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(
            @PathVariable Long id) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Employee not found"));

        employeeRepository.delete(employee);

        return "Employee Deleted Successfully";
    }
}
