package com.joselito.demo;

import com.joselito.demo.dto.ErrorResponse;
import com.joselito.demo.dto.ResponseDto;
import com.joselito.demo.dto.RequestDto;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface ILoginApi {

    @Tag(name = "login", description = "request to login with email and password")
    @Operation(summary = "Login", description = "Loren ipsum")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "Login exitoso"
            ),
            @ApiResponse(
                responseCode = "500", description = "${api.responseCodes.internalServer.description}",
                 content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                 }
            ), 
            @ApiResponse(
                 responseCode = "417", description = "No se encontro las credenciales del usuario", 
                 content = { 
                    @Content(mediaType = "aplication/json",
                            schema = @Schema(implementation = ErrorResponse.class))
                 }
            )
        }
    )
    public ResponseEntity login(RequestDto credentials);

}
