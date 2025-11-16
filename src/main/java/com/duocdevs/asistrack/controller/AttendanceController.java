package com.duocdevs.asistrack.controller;

import com.duocdevs.asistrack.model.Attendance;
import com.duocdevs.asistrack.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAll() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{id}")
    public Attendance getById(@PathVariable Integer id) {
        return attendanceService.getAttendanceById(id);
    }

    @PostMapping
    public Attendance save(@RequestBody Attendance attendance) {
        return attendanceService.saveAttendance(attendance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        attendanceService.deleteAttendance(id);
    }
}