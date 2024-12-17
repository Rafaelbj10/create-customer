package com.cdps.infra.sql;

public class CustomerSql {

    public static final String INSERT = "INSERT INTO customer (name, email, document_number, phone, birth_date, address, active) " +
            "VALUES " +
            "(:name, :email, :documentNumber, :phone, :birthDate, :address, :active) ";

}
