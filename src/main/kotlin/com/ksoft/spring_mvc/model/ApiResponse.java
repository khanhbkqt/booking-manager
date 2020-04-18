package com.ksoft.spring_mvc.model;

import lombok.Data;

@Data
public class ApiResponse {
    private boolean success;
    private String message;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static ApiResponse success(String message) {
        return new ApiResponse(true, message);
    }

    public static ApiResponse failed(String message) {
        return new ApiResponse(false, message);
    }
}
