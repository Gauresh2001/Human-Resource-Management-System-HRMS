package com.hrms.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentRequestDto {

    @NotBlank(message = "Department name is required")
    private String departmentName;

    @NotBlank(message = "Department code is required")
    private String departmentCode;

    private String description;
}
