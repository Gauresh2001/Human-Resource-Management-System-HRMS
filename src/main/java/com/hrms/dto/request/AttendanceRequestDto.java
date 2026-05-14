package com.hrms.dto.request;
import java.time.LocalDate;
import java.time.LocalTime;

import com.hrms.enums.AttendanceStatus;

import lombok.Data;

@Data
public class AttendanceRequestDto {

    private LocalDate attendanceDate;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private Double workingHours;

    private AttendanceStatus status;

    private Long employeeId;
}
