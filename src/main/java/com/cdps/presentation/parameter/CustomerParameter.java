package com.cdps.presentation.parameter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CustomerParameter {

    private String name;
    private String email;
    private String documentNumber;
    private String phone;
    private LocalDate birthDate;
    private String address;

}
