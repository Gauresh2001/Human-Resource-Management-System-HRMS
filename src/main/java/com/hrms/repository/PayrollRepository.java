package com.hrms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.Payroll;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    List<Payroll> findByEmployeeId(Long employeeId);

    List<Payroll> findByPayrollYear(Integer payrollYear);

    List<Payroll> findByPayrollMonth(String payrollMonth);
}
