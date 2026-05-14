package com.hrms.dto.response;
import java.time.LocalDate;
import java.time.LocalTime;

import com.hrms.enums.AttendanceStatus;

import lombok.Data;

@Data
public class AttendanceResponseDto {

    private Long id;

    private LocalDate attendanceDate;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private Double workingHours;

    private AttendanceStatus status;

    private String employeeName;
}
