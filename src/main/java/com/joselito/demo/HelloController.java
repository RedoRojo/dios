package com.joselito.demo; 

import org.springframework.web.bind.annotation.RestController; 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;


import com.joselito.demo.dto.ProductDto;

import io.sentry.Sentry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

import org.springframework.http.ResponseEntity;

@RestController
public class HelloController implements IHelloApi {

    @GetMapping("/")
    public String index() {
        try{
            throw new Exception("this is a test"); 
        } catch (Exception e) {
            Sentry.captureException(e);
        }
        return "Greetings from spring boot"; 
    }

    public ResponseEntity<ProductDto> obtain(String id) {
        var product = new ProductDto(1, "joselito", 1); 
        return ResponseEntity.ok(product); 
    } 

    public ResponseEntity create(ProductDto product) {
        return ResponseEntity.badRequest().body("JAJAJ"); 
    }

}
