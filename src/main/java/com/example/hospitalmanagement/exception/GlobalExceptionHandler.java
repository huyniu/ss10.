package com.example.hospitalmanagement.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /* =========================================================================
     * BÀI TẬP 2: CHUẨN HÓA MÃ LỖI HTTP
     * =========================================================================
     * TH1: Người dùng gửi yêu cầu đặt lịch khám nhưng bỏ trống tên bệnh nhân.
     * -> Chọn mã: 400 Bad Request.
     * -> Lý do: Tên bệnh nhân là dữ liệu bắt buộc. Việc bỏ trống là lỗi từ phía
     * Client (gửi sai định dạng/thiếu dữ liệu).
     *
     * TH2: Tìm kiếm hồ sơ bệnh án với ID là 999 nhưng Database không tồn tại.
     * -> Chọn mã: 404 Not Found.
     * -> Lý do: Cú pháp Client gửi hợp lệ, nhưng tài nguyên thực tế không tồn tại.
     *
     * TH3: Hệ thống đang chạy thì Database sập, không thể truy vấn dữ liệu.
     * -> Chọn mã: 500 Internal Server Error.
     * -> Lý do: Lỗi phát sinh từ Backend (sự cố hệ thống), không phải lỗi của Client.
     *
     * TH4: Người dùng nhập tuổi bệnh nhân là -5.
     * -> Chọn mã: 400 Bad Request.
     * -> Lý do: Dữ liệu vi phạm logic nghiệp vụ. Client chịu trách nhiệm về
     * việc truyền dữ liệu không hợp lệ.
     * =========================================================================
     */

    // Các hàm @ExceptionHandler có thể được viết tiếp ở bên dưới...
}