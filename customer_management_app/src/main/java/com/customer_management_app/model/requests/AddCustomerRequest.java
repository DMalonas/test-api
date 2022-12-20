package com.customer_management_app.model.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AddCustomerRequest {
    @JsonProperty
    @JsonFormat(pattern = "dd-MM-yyyy")
    Date dateOfBirth;
    @JsonProperty String forename;
    @JsonProperty String surname;
}
