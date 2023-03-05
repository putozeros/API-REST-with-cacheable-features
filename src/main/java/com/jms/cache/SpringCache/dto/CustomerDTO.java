package com.jms.cache.SpringCache.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "customer_id")
    private int customerId;

    @JsonProperty(value = "customer_name")
    private String customerName;
}
