package com.joselito.demo; 

import org.springframework.http.ResponseEntity;

import com.joselito.demo.dto.ErrorResponse;
import com.joselito.demo.dto.PayRequestDto;
import com.joselito.demo.dto.PayResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface IPayApi {
    @Tag(name = "Pago con tarjeta", description = "Obtain one product by id")
    @Operation(summary = "Pago con tarjeta", description = "Loren ipsum")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "ok"
            ),
            @ApiResponse(
                responseCode = "500", description = "${api.responseCodes.internalServer.description}",
                 content = {
                    @Content(mediaType = "application/json",
                             schema = @Schema(implementation = ErrorResponse.class))
                 }

            )
        }
    )
    public ResponseEntity pay(PayRequestDto data);

    
}
