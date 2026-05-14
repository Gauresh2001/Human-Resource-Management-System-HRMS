package com.hrms.validation;
import com.hrms.dto.request.EmployeeRequestDto;

public class EmployeeValidator {

    private EmployeeValidator() {

    }

    // Validate Employee Email
    public static boolean isValidEmail(
            String email) {

        return email != null
                && email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    // Validate Phone Number
    public static boolean isValidPhone(
            String phone) {

        return phone != null
                && phone.matches("[0-9]{10}");
    }

    // Validate Salary
    public static boolean isValidSalary(
            Double salary) {

        return salary != null
                && salary > 0;
    }

    // Validate Employee Object
    public static boolean validateEmployee(
            EmployeeRequestDto dto) {

        return dto != null
                && dto.getFirstName() != null
                && dto.getLastName() != null
                && isValidEmail(dto.getEmail())
                && isValidPhone(dto.getPhone())
                && isValidSalary(dto.getSalary());
    }
}
