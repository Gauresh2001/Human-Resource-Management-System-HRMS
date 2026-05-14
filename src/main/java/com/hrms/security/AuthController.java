package com.hrms.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.hrms.entity.Attendance;
import com.hrms.entity.Employee;
import com.hrms.entity.LeaveRequest;
import com.hrms.entity.Payroll;
import com.hrms.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final EmployeeRepository employeeRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            EmployeeRepository employeeRepository,
            PasswordEncoder passwordEncoder) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // =========================
    // REGISTER API
    // =========================
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody Employee employee) {

        // Encode Password
        employee.setPassword(
                passwordEncoder.encode(
                        employee.getPassword()));

        // =========================
        // ATTENDANCE MAPPING
        // =========================
        if (employee.getAttendances() != null) {

            for (Attendance attendance :
                    employee.getAttendances()) {

                attendance.setEmployee(employee);
            }
        }

        // =========================
        // LEAVE MAPPING
        // =========================
        if (employee.getLeaves() != null) {

            for (LeaveRequest leave :
                    employee.getLeaves()) {

                leave.setEmployee(employee);
            }
        }

        // =========================
        // PAYROLL MAPPING
        // =========================
        if (employee.getPayrolls() != null) {

            for (Payroll payroll :
                    employee.getPayrolls()) {

                payroll.setEmployee(employee);
            }
        }

        // SAVE EMPLOYEE
        employeeRepository.save(employee);

        return ResponseEntity.ok(
                "Employee Registered Successfully");
    }

    // =========================
    // LOGIN API
    // =========================
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody Map<String, String> request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.get("email"),
                                request.get("password")));

        if (authentication.isAuthenticated()) {

            String token =
                    jwtService.generateToken(
                            request.get("email"));

            Map<String, String> response =
                    new HashMap<>();

            response.put("token", token);

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.badRequest()
                .body("Invalid Credentials");
    }
}
