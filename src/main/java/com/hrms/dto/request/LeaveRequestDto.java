package com.hrms.dto.request;

import java.time.LocalDate;

import com.hrms.enums.LeaveStatus;
import com.hrms.enums.LeaveType;

import lombok.Data;

@Data
public class LeaveRequestDto {

    private LocalDate fromDate;

    private LocalDate toDate;

    private String reason;

    private LeaveType leaveType;

    private LeaveStatus leaveStatus;

    private Long employeeId;

}
