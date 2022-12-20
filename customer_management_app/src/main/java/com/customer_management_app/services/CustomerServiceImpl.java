package com.customer_management_app.services;



import com.customer_management_app.model.Customer;
import com.customer_management_app.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer addCustomer(String forename, String surname, Date date) {
        Customer customer = new Customer();
        customer.setForename(forename);
        customer.setSurname(surname);
        customer.setDate(date);
        return customerRepository.save(customer);
    }
}
