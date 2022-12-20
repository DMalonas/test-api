package com.customer_management_app.services;



import com.customer_management_app.model.Customer;

import java.util.Date;

public interface CustomerService {
    Customer addCustomer(String forename, String surname, Date date);
}
