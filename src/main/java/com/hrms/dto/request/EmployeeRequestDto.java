package com.hrms.dto.request;
import java.time.LocalDate;

import com.hrms.enums.EmployeeStatus;
import com.hrms.enums.Gender;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeRequestDto {

    // ❌ REMOVE employeeCode (AUTO GENERATED)

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String phone;

    private String address;

    private Gender gender;

    private Double salary;

    private LocalDate joiningDate;

    private EmployeeStatus status;

    private Long departmentId;

    private Long roleId;
}
