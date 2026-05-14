package com.hrms.validation;
import com.hrms.dto.request.PayrollRequestDto;

public class PayrollValidator {

    private PayrollValidator() {

    }

    // Validate Payroll
    public static boolean validatePayroll(
            PayrollRequestDto dto) {

        return dto != null
                && dto.getBasicSalary() != null
                && dto.getBasicSalary() > 0
                && dto.getWorkingDays() != null
                && dto.getPresentDays() != null
                && dto.getEmployeeId() != null;
    }
}
