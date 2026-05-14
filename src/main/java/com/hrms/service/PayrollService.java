package com.hrms.service;

import java.util.List;

import com.hrms.entity.Payroll;

public interface PayrollService {
	
	  Payroll generatePayroll(Payroll payroll);

	    List<Payroll> getAllPayrolls();

	    Payroll getPayrollById(Long id);

	    Payroll updatePayroll(Long id, Payroll payroll);

	    void deletePayroll(Long id);

}
