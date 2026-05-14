package com.hrms.dto.response;
import com.hrms.enums.PayrollStatus;

import lombok.Data;

@Data
public class PayrollResponseDto {

    private Long id;

    private Double basicSalary;

    private Double allowances;

    private Double deductions;

    private Double bonus;

    private Double tax;

    private Double netSalary;

    private Integer workingDays;

    private Integer presentDays;

    private String payrollMonth;

    private Integer payrollYear;

    private PayrollStatus payrollStatus;

    private String employeeName;
}
