package com.customer_management_app.services;


import com.customer_management_app.model.Account;
import com.customer_management_app.model.Customer;

public interface AccountService {
    Account createAccount(Customer customer, int accountNumber);
}
