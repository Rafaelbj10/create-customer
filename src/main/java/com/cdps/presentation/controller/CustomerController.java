package com.cdps.presentation.controller;


import com.cdps.domain.model.Customer;
import com.cdps.domain.service.CustomerService;
import com.cdps.presentation.parameter.CustomerParameter;
import com.cdps.presentation.presenter.CustomerPresenter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CreateCustomerApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<CustomerPresenter> createCustomer(CustomerParameter customer) {

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));

    }
}
