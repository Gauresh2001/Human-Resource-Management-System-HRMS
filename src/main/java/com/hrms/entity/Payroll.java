package com.hrms.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.enums.PayrollStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payrolls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Enumerated(EnumType.STRING)
    private PayrollStatus payrollStatus;

    @ManyToOne

    @JsonIgnore
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
}
