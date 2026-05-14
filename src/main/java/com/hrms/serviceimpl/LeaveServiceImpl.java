package com.hrms.serviceimpl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.entity.LeaveRequest;
import com.hrms.repository.LeaveRepository;
import com.hrms.service.LeaveService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    @Override
    public LeaveRequest applyLeave(LeaveRequest leaveRequest) {
        return leaveRepository.save(leaveRequest);
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public LeaveRequest getLeaveById(Long id) {
        return leaveRepository.findById(id).orElseThrow();
    }

    @Override
    public LeaveRequest updateLeave(Long id, LeaveRequest leaveRequest) {

        LeaveRequest existing = leaveRepository.findById(id).orElseThrow();

        existing.setFromDate(leaveRequest.getFromDate());
        existing.setToDate(leaveRequest.getToDate());
        existing.setReason(leaveRequest.getReason());
        existing.setLeaveStatus(leaveRequest.getLeaveStatus());

        return leaveRepository.save(existing);
    }

    @Override
    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }
}
