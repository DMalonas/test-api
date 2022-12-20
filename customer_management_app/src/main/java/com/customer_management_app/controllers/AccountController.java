package com.customer_management_app.controllers;



import com.customer_management_app.model.Account;
import com.customer_management_app.model.AccountRepository;
import com.customer_management_app.model.Customer;
import com.customer_management_app.model.CustomerRepository;
import com.customer_management_app.model.requests.CreateAccountRequest;
import com.customer_management_app.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;


    @GetMapping("/id/{id}")
    ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> accountById = accountRepository.findById(id);
        return ResponseEntity.of(accountById);
    }

    @PostMapping("/create")
    ResponseEntity<Account> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        int accountNumber = createAccountRequest.getAccountNumber();
        long customerId = createAccountRequest.getCustomerId();
        Optional<Customer> customerById = customerRepository.findById(customerId);
        if (customerById.isPresent()) {
            Account account = accountService.createAccount(customerById.get(), accountNumber);
            return ResponseEntity
                    .ok(account);
        }
        return ResponseEntity.notFound().build();
    }
}
