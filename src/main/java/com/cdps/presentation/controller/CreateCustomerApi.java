package com.cdps.presentation.controller;

import com.cdps.domain.model.Customer;
import com.cdps.presentation.parameter.CustomerParameter;
import com.cdps.presentation.presenter.CustomerPresenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface CreateCustomerApi {

    @Tag(name = "Clientes", description = "Endpoint para criacao de cliente na base")
    @PostMapping(value = "/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Criacao de cliente",
            description = "Cria o cliente no banco de dados",
            tags = {"clientes"},
            responses = {
                    @ApiResponse(description = "Sucesso com Body", responseCode = "201", content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Customer.class))),
                    @ApiResponse(description = "Erros com Payload de entrada", responseCode = "400", content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Error.class))),
                    @ApiResponse(description = "Erro de Negócio", responseCode = "422", content = @Content(mediaType = APPLICATION_JSON_VALUE)),
                    @ApiResponse(description = "Erro Genérico", responseCode = "500", content = @Content(mediaType = APPLICATION_JSON_VALUE)),
            }
    )
    ResponseEntity<CustomerPresenter> createCustomer(@RequestBody CustomerParameter customer);
}
