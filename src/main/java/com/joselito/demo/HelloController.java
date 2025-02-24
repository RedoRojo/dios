package com.joselito.demo; 

import org.springframework.web.bind.annotation.RestController; 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;

import com.joselito.demo.dto.ProductDto;

import io.sentry.Sentry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;


import java.util.Set;

import org.springframework.http.ResponseEntity;

public class HelloController implements IHelloApi {

    public String index() {
        try{
            throw new Exception("this is a test"); 
        } catch (Exception e) {
            Sentry.captureException(e);
        }
        return "Greetings from spring boot"; 
    }


    public ResponseEntity<ProductDto> obtain(@PathVariable String id) {
        
        var product = new ProductDto(1,"a", 2);
        return ResponseEntity.ok(product);
    }
    

    public ResponseEntity create(@RequestBody ProductDto product) {

        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(product);
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V7);
            JsonSchema jsonSchema = factory.getSchema(HelloController.class.getClassLoader().getResourceAsStream("schemas/product.json"));
            JsonNode jsonNode = mapper.readTree(json);
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode); 

            String errorsCombined = "";
            for( ValidationMessage error: errors) {
                errorsCombined += error.toString() +  "\n";
            }

            if(errors.size() > 0) {
                return ResponseEntity.badRequest().body("Please fix your JSON!,\n"+errorsCombined);
            }
            return ResponseEntity.ok(product);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.ok(product);
        }
    }

}
