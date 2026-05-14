package com.hrms.validation;
import com.hrms.dto.request.DepartmentRequestDto;

public class DepartmentValidator {

    private DepartmentValidator() {

    }

    // Validate Department
    public static boolean validateDepartment(
            DepartmentRequestDto dto) {

        return dto != null
                && dto.getDepartmentName() != null
                && !dto.getDepartmentName().isEmpty()
                && dto.getDepartmentCode() != null
                && !dto.getDepartmentCode().isEmpty();
    }
}
