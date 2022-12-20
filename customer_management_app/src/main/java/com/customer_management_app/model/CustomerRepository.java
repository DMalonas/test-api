package com.customer_management_app.model;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByForenameAndSurname(String forename, String surname);
}
