package com.hrms.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrms.entity.Attendance;
import com.hrms.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    // Mark Attendance
    @PostMapping
    public ResponseEntity<Attendance> markAttendance(
            @RequestBody Attendance attendance) {

        return new ResponseEntity<>(
                attendanceService.markAttendance(attendance),
                HttpStatus.CREATED);
    }

    // Get All Attendance
    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendance() {

        return ResponseEntity.ok(
                attendanceService.getAllAttendance());
    }

    // Get Attendance By ID
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                attendanceService.getAttendanceById(id));
    }

    // Update Attendance
    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(
            @PathVariable Long id,
            @RequestBody Attendance attendance) {

        return ResponseEntity.ok(
                attendanceService.updateAttendance(id, attendance));
    }

    // Delete Attendance
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttendance(
            @PathVariable Long id) {

        attendanceService.deleteAttendance(id);

        return ResponseEntity.ok(
                "Attendance Deleted Successfully");
    }
}
