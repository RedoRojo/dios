package com.joselito.demo.dto;

public class PayRequestDto {

    private String cardNumber; 
    private int cvv; 
    private String expirationDate; 

    public PayRequestDto(String carNumber, int cvv, String expirationDate) { 
        this.cardNumber = carNumber; 
        this.cvv = cvv; 
        this.expirationDate = expirationDate; 
    }

}
