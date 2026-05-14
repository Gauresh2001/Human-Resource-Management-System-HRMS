package com.hrms.service;

import java.util.List;

import com.hrms.entity.Attendance;

public interface AttendanceService {
	
	 Attendance markAttendance(Attendance attendance);

	    List<Attendance> getAllAttendance();

	    Attendance getAttendanceById(Long id);

	    Attendance updateAttendance(Long id, Attendance attendance);

	    void deleteAttendance(Long id);

}
