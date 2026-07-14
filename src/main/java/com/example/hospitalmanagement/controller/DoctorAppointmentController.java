package com.example.hospitalmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorAppointmentController {

    @GetMapping("/{doctorId}/appointments")
    public ResponseEntity<String> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok("API thành công: Lấy danh sách lịch hẹn của bác sĩ có ID = " + doctorId);
    }
}