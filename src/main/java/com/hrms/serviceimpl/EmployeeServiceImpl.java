package com.hrms.serviceimpl;
import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hrms.dto.request.EmployeeRequestDto;
import com.hrms.entity.Employee;
import com.hrms.enums.EmployeeStatus;
import com.hrms.exception.ResourceNotFoundException;
import com.hrms.repository.EmployeeRepository;
import com.hrms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            PasswordEncoder passwordEncoder,
            ModelMapper modelMapper) {

        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    // ================= ADD EMPLOYEE =================

    @Override
    public Employee addEmployee(
            EmployeeRequestDto employeeRequestDto) {

        Employee employee =
                modelMapper.map(
                        employeeRequestDto,
                        Employee.class);

        // Auto Generate Employee Code
        String employeeCode =
                "EMP" + System.currentTimeMillis();

        employee.setEmployeeCode(employeeCode);

        // Encrypt Password
        employee.setPassword(
                passwordEncoder.encode(
                        employee.getPassword()));

        // Default Values
        employee.setJoiningDate(LocalDate.now());

        employee.setStatus(
                EmployeeStatus.ACTIVE);

        return employeeRepository.save(employee);
    }

    // ================= GET ALL EMPLOYEES =================

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    // ================= GET EMPLOYEE BY ID =================

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee Not Found"));
    }

    // ================= UPDATE EMPLOYEE =================

    @Override
    public Employee updateEmployee(
            Long id,
            EmployeeRequestDto employeeRequestDto) {

        Employee existingEmployee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee Not Found"));

        existingEmployee.setFirstName(
                employeeRequestDto.getFirstName());

        existingEmployee.setLastName(
                employeeRequestDto.getLastName());

        existingEmployee.setEmail(
                employeeRequestDto.getEmail());

        existingEmployee.setPhone(
                employeeRequestDto.getPhone());

        existingEmployee.setAddress(
                employeeRequestDto.getAddress());

        existingEmployee.setGender(
                employeeRequestDto.getGender());

        existingEmployee.setSalary(
                employeeRequestDto.getSalary());

        return employeeRepository.save(
                existingEmployee);
    }

    // ================= DELETE EMPLOYEE =================

    @Override
    public void deleteEmployee(Long id) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Employee Not Found"));

        employeeRepository.delete(employee);
    }
}
