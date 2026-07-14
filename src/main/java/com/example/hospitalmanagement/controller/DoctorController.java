package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.ApiResponse;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // Lấy danh sách toàn bộ bác sĩ - Đã chuẩn hóa Response
    @GetMapping
    public ResponseEntity<ApiResponse<List<Doctor>>> getAllDoctors() {
        // 1. Lấy dữ liệu từ Database
        List<Doctor> doctors = doctorRepository.findAll();

        // 2. Tạo thông tin Meta ảo (Trong thực tế sẽ dùng Pageable của Spring Data JPA)
        ApiResponse.MetaData meta = new ApiResponse.MetaData(
                doctors.size(), // Giả sử tổng số bản ghi bằng size của list
                1,              // Đang ở trang 1
                1,              // Tổng 1 trang
                10              // Kích thước 10 bản ghi/trang
        );

        // 3. Đóng gói dữ liệu vào ApiResponse
        ApiResponse<List<Doctor>> response = new ApiResponse<>(
                "success",
                HttpStatus.OK.value(), // Lấy số 200
                doctors,
                meta
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // ... các method khác (POST, PUT, DELETE) bạn cũng có thể bọc bằng ApiResponse tương tự ...
}