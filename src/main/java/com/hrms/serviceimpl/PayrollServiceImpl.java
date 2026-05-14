package com.hrms.serviceimpl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.entity.Payroll;
import com.hrms.repository.PayrollRepository;
import com.hrms.service.PayrollService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository payrollRepository;

    @Override
    public Payroll generatePayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    @Override
    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id).orElseThrow();
    }

    @Override
    public Payroll updatePayroll(Long id, Payroll payroll) {

        Payroll existing = payrollRepository.findById(id).orElseThrow();

        existing.setBasicSalary(payroll.getBasicSalary());
        existing.setAllowances(payroll.getAllowances());
        existing.setDeductions(payroll.getDeductions());
        existing.setNetSalary(payroll.getNetSalary());

        return payrollRepository.save(existing);
    }

    @Override
    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
