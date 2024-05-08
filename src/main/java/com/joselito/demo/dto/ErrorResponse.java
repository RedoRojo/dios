package com.joselito.demo.dto; 

import lombok.Getter; 
import lombok.Setter; 
import jakarta.validation.constraints.NotNull; 


public class ErrorResponse{

    @NotNull
    final String message; 
    public ErrorResponse(String message) {
        this.message = message; 
    }

}