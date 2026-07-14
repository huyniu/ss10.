package com.example.hospitalmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DoctorDTO {
    @NotBlank(message = "Tên bác sĩ không được để trống")
    private String name;

    @NotBlank(message = "Chuyên khoa không được để trống")
    private String specialization;

    private String phone;
}