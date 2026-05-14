package com.hrms.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Employee;
import com.hrms.enums.EmployeeStatus;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	  // Login Authentication
    Optional<Employee> findByEmail(String email);

    // Employee Search
    Optional<Employee> findByEmployeeCode(String employeeCode);

    // Validation Checks
    boolean existsByEmail(String email);

    boolean existsByEmployeeCode(String employeeCode);

    boolean existsByPhone(String phone);

    // Employee Status
    Optional<Employee> findByStatus(EmployeeStatus status);

    // Active Employee Check
    Optional<Employee> findByEmailAndEnabled(String email, Boolean enabled);
}
