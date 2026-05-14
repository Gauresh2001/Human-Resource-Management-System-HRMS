package com.hrms.entity;
import java.time.LocalDate;
import java.util.List;

import com.hrms.enums.EmployeeStatus;
import com.hrms.enums.Gender;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_code", unique = true)
    private String employeeCode;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    private String phone;

    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Double salary;

    private LocalDate joiningDate;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    private String profileImage;

    private Boolean enabled = true;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<LeaveRequest> leaves;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Payroll> payrolls;

    // AUTO GENERATE EMPLOYEE CODE
    @PrePersist
    public void generateEmployeeCode() {

        if (this.employeeCode == null
                || this.employeeCode.isEmpty()) {

            this.employeeCode =
                    "EMP" + System.currentTimeMillis();
        }

        if (this.joiningDate == null) {
            this.joiningDate = LocalDate.now();
        }

        if (this.status == null) {
            this.status = EmployeeStatus.ACTIVE;
        }
    }
    
    
	    
	    
	    
	    
	    
}
