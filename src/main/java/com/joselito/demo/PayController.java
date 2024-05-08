package com.joselito.demo;
import org.springframework.web.bind.annotation.RestController; 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;

import com.joselito.demo.dto.PayResponseDto;
import com.joselito.demo.dto.PayRequestDto;

import io.sentry.Sentry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

import java.util.Set;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

@RestController
public class PayController implements IPayApi{

    @PostMapping(value = "/pay", produces = "application/json")
    public ResponseEntity pay(@RequestBody PayRequestDto credentials) {
        var response = new PayResponseDto(1, "none");  
        return ResponseEntity.ok(response); 
    } 
}
