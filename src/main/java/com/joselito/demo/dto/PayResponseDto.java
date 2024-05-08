package com.joselito.demo.dto;

public class PayResponseDto {
    private int statusCode; 
    private String message; 

    public PayResponseDto(int statusCode, String message) { 
        this.statusCode = statusCode; 
        this.message = message; 
    }

}
