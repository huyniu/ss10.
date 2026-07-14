package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.DoctorDTO;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // 1. Lấy danh sách toàn bộ bác sĩ
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    // 2. Lấy thông tin chi tiết một bác sĩ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return new ResponseEntity<>(doctor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Không tìm thấy bác sĩ với ID: " + id, HttpStatus.NOT_FOUND);
    }

    // 3. Thêm mới một bác sĩ
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setPhone(dto.getPhone());

        Doctor savedDoctor = doctorRepository.save(doctor);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    // 4. Cập nhật thông tin bác sĩ
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long id, @Valid @RequestBody DoctorDTO dto) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy bác sĩ với ID: " + id, HttpStatus.NOT_FOUND);
        }

        Doctor existingDoctor = optionalDoctor.get();
        existingDoctor.setName(dto.getName());
        existingDoctor.setSpecialization(dto.getSpecialization());
        existingDoctor.setPhone(dto.getPhone());

        doctorRepository.save(existingDoctor);
        return new ResponseEntity<>(existingDoctor, HttpStatus.OK);
    }

    // 5. Xóa bác sĩ khỏi hệ thống
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        if (!doctorRepository.existsById(id)) {
            return new ResponseEntity<>("Không tìm thấy bác sĩ với ID: " + id, HttpStatus.NOT_FOUND);
        }
        doctorRepository.deleteById(id);
        return new ResponseEntity<>("Đã xóa thành công bác sĩ có ID: " + id, HttpStatus.OK);
    }
}