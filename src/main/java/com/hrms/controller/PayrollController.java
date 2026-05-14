package com.hrms.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrms.entity.Payroll;
import com.hrms.service.PayrollService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payrolls")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PayrollController {

    private final PayrollService payrollService;

    @PostMapping
    public ResponseEntity<Payroll> generatePayroll(
            @RequestBody Payroll payroll) {

        return new ResponseEntity<>(
                payrollService.generatePayroll(payroll),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayrolls() {

        return ResponseEntity.ok(
                payrollService.getAllPayrolls());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                payrollService.getPayrollById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payroll> updatePayroll(
            @PathVariable Long id,
            @RequestBody Payroll payroll) {

        return ResponseEntity.ok(
                payrollService.updatePayroll(id, payroll));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayroll(
            @PathVariable Long id) {

        payrollService.deletePayroll(id);

        return ResponseEntity.ok(
                "Payroll Deleted Successfully");
    }
}
