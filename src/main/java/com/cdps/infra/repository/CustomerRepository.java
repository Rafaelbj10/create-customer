package com.cdps.infra.repository;

import com.cdps.domain.exception.CustomerAlreadyExistsException;
import com.cdps.domain.model.Customer;
import com.cdps.infra.sql.CustomerSql;
import com.cdps.presentation.parameter.CustomerParameter;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Objects;

@RequiredArgsConstructor
@Repository
public class CustomerRepository {

    private final NamedParameterJdbcOperations jdbcTemplate;

    public long createCustomer(final CustomerParameter customer){
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", customer.getName());
        params.addValue("email", customer.getEmail());
        params.addValue("documentNumber", customer.getDocumentNumber());
        params.addValue("phone", customer.getPhone());
        params.addValue("birthDate", customer.getBirthDate());
        params.addValue("address", customer.getAddress());
        params.addValue("createTime", LocalDateTime.now().toString());
        params.addValue("active", true);

        try {
            jdbcTemplate.update(CustomerSql.INSERT, params, keyHolder);
            return Objects.requireNonNull(keyHolder.getKey()).longValue();
        } catch (DataIntegrityViolationException e) {
            throw new CustomerAlreadyExistsException("Cliente ja cadastrado.");
        }
    }
}
