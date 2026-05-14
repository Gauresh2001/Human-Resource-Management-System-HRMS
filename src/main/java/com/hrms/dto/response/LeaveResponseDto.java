

package com.hrms.dto.response;

import java.time.LocalDate;

import com.hrms.enums.LeaveStatus;
import com.hrms.enums.LeaveType;

import lombok.Data;

@Data
public class LeaveResponseDto {

    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    private String reason;

    private LeaveType leaveType;

    private LeaveStatus leaveStatus;

    private String employeeName; 

}
