package com.hrms.serviceimpl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.entity.Attendance;
import com.hrms.repository.AttendanceRepository;
import com.hrms.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

   
    public Attendance markAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElseThrow();
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance attendance) {

        Attendance existing = attendanceRepository.findById(id).orElseThrow();

        existing.setAttendanceDate(attendance.getAttendanceDate());
        existing.setStatus(attendance.getStatus());
        existing.setCheckInTime(attendance.getCheckInTime());
        existing.setCheckOutTime(attendance.getCheckOutTime());

        return attendanceRepository.save(existing);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
