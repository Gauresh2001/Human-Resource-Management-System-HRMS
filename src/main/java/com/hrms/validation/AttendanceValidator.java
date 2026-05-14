package com.hrms.validation;
import com.hrms.dto.request.AttendanceRequestDto;

public class AttendanceValidator {

    private AttendanceValidator() {

    }

    // Validate Attendance
    public static boolean validateAttendance(
            AttendanceRequestDto dto) {

        return dto != null
                && dto.getAttendanceDate() != null
                && dto.getStatus() != null
                && dto.getEmployeeId() != null;
    }
}
