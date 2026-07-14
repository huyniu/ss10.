package com.example.hospitalmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientPrescriptionController {

    // Lấy một đơn thuốc cụ thể của một bệnh nhân
    @GetMapping("/{patientId}/prescriptions/{prescriptionId}")
    public ResponseEntity<String> getPrescription(@PathVariable Long patientId, @PathVariable Long prescriptionId) {
        return ResponseEntity.ok("API thành công: Lấy đơn thuốc " + prescriptionId + " của bệnh nhân " + patientId);
    }

    // Thêm một đơn thuốc mới cho bệnh nhân
    @PostMapping("/{patientId}/prescriptions")
    public ResponseEntity<String> createPrescription(@PathVariable Long patientId, @RequestBody Object mockDTO) {
        return ResponseEntity.ok("API thành công: Đã thêm đơn thuốc mới cho bệnh nhân " + patientId);
    }
}