package com.hrms.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrms.entity.LeaveRequest;
import com.hrms.service.LeaveService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping
    public ResponseEntity<LeaveRequest> applyLeave(
            @RequestBody LeaveRequest leaveRequest) {

        return new ResponseEntity<>(
                leaveService.applyLeave(leaveRequest),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaves() {

        return ResponseEntity.ok(
                leaveService.getAllLeaves());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getLeaveById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                leaveService.getLeaveById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequest> updateLeave(
            @PathVariable Long id,
            @RequestBody LeaveRequest leaveRequest) {

        return ResponseEntity.ok(
                leaveService.updateLeave(id, leaveRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeave(
            @PathVariable Long id) {

        leaveService.deleteLeave(id);

        return ResponseEntity.ok(
                "Leave Deleted Successfully");
    }
}
