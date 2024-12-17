package com.cdps.domain.service;

import com.cdps.domain.model.Customer;
import com.cdps.infra.repository.CustomerRepository;
import com.cdps.presentation.parameter.CustomerParameter;
import com.cdps.presentation.presenter.CustomerPresenter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    @Transactional(readOnly = false)
    public CustomerPresenter create(CustomerParameter customer) {

        var idClient = repository.createCustomer(customer);

        return CustomerPresenter.builder()
                .id(idClient)
                .build();
    }


}
