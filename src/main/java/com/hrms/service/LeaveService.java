package com.hrms.service;

import java.util.List;

import com.hrms.entity.LeaveRequest;

public interface LeaveService {
	
	  LeaveRequest applyLeave(LeaveRequest leaveRequest);

	    List<LeaveRequest> getAllLeaves();

	    LeaveRequest getLeaveById(Long id);

	    LeaveRequest updateLeave(Long id, LeaveRequest leaveRequest);

	    void deleteLeave(Long id);

}
