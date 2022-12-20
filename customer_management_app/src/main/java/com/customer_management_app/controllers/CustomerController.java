package com.customer_management_app.controllers;

import com.customer_management_app.model.Customer;
import com.customer_management_app.model.CustomerRepository;
import com.customer_management_app.model.requests.AddCustomerRequest;
import com.customer_management_app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/id/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> byId = customerRepository.findById(id);
        return ResponseEntity.of(byId);
    }

    @PostMapping("/create")
    ResponseEntity<Object> addCustomer(@RequestBody AddCustomerRequest addCustomerRequest) {
        Optional<Customer> byForenameAndBySurnameOpt = customerRepository.findByForenameAndSurname(addCustomerRequest.getForename(), addCustomerRequest.getSurname());
        if (byForenameAndBySurnameOpt.isEmpty()) {
            return ResponseEntity.ok(customerService.addCustomer(addCustomerRequest.getForename(), addCustomerRequest.getSurname(), addCustomerRequest.getDateOfBirth()));
        }
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body("Customer already registered");
    }
}
