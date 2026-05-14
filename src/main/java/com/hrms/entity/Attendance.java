package com.hrms.entity;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.enums.AttendanceStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate attendanceDate;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    private Double workingHours;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    @ManyToOne

    @JsonIgnore
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
}
