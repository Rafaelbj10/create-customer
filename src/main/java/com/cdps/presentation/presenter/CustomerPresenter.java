package com.cdps.presentation.presenter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
public class CustomerPresenter implements Serializable {

    @Schema(description = "Numedo do Id do cliente", example = "0001")
    private Long id;

}
