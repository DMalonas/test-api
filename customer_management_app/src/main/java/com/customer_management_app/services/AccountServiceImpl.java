package com.customer_management_app.services;



import com.customer_management_app.model.Account;
import com.customer_management_app.model.AccountRepository;
import com.customer_management_app.model.Customer;
import com.customer_management_app.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;


    @Override
    public Account createAccount(Customer customer, int accountNumber) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setCustomer(customer);
        Account savedAccount = accountRepository.save(account);
        customer.addAccount(account);
        customerRepository.save(customer);
        return savedAccount;
    }
}
