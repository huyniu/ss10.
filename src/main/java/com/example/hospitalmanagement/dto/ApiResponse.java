package com.example.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private String status;
    private int code;
    private T data;
    private MetaData meta;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MetaData {
        private long totalRecords; // Tổng số bản ghi trong Database
        private int currentPage;   // Trang hiện tại
        private int totalPages;    // Tổng số trang
        private int pageSize;      // Số bản ghi trên 1 trang
    }
}