package com.hrms.validation;
import com.hrms.dto.request.LeaveRequestDto;

public class LeaveRequestValidator {

    private LeaveRequestValidator() {

    }

    // Validate Leave Request
    public static boolean validateLeaveRequest(
            LeaveRequestDto dto) {

        return dto != null
                && dto.getFromDate() != null
                && dto.getToDate() != null
                && dto.getReason() != null
                && !dto.getReason().isEmpty()
                && dto.getEmployeeId() != null;
    }
}
