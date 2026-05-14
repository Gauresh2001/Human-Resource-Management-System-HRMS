package com.hrms.dto.response;

import java.time.LocalDate;

import com.hrms.enums.EmployeeStatus;
import com.hrms.enums.Gender;

import lombok.Data;

@Data
public class EmployeeResponseDto {

    private Long id;

    private String employeeCode;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private Gender gender;

    private Double salary;

    private LocalDate joiningDate;

    private EmployeeStatus status;

    private String profileImage;

    private String departmentName;

    private String roleName; 

}
