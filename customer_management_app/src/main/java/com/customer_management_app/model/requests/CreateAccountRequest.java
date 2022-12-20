package com.customer_management_app.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateAccountRequest {
    @JsonProperty int accountNumber;
    @JsonProperty long customerId;
}
