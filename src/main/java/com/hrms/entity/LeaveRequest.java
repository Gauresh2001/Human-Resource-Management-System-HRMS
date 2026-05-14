package com.hrms.entity;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.enums.LeaveStatus;
import com.hrms.enums.LeaveType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leave_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    private String reason;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    @ManyToOne

    @JsonIgnore
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    
}
