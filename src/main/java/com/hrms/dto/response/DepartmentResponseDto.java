package com.hrms.dto.response;
import lombok.Data;

@Data
public class DepartmentResponseDto {

    private Long id;

    private String departmentName;

    private String departmentCode;

    private String description;
}
