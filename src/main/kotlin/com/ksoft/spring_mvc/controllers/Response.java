package com.ksoft.spring_mvc.controllers;

import lombok.Data;

@Data
public class Response {
    private boolean success;
    private String message;

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static Response success(String message) {
        return new Response(true, message);
    }

    public static Response failed(String message) {
        return new Response(false, message);
    }
}
