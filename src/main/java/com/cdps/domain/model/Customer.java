package com.cdps.domain.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private String name;
    private String email;
    private String documentNumber;
    private String phone;
    private Date birthdate;
    private String address;
    private boolean active;


}
