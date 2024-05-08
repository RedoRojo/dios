package com.joselito.demo.dto;

public class ResponseDto{

    private String token; 
    private String timestamp; 

    public ResponseDto(String token, String timestamp) {
        this.token = token;
        this.timestamp = timestamp; 
    }

    public String getToken() {
        return this.token; 
    }
    public void setToken(String token) {
        this.token = token; 
    }

    public String getTimestamp() {
        return timestamp; 
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp; 
    }
    
}
