package com.streamhub.videostreamhub.customer.controller.dto;


import com.streamhub.videostreamhub.customer.repository.Customer;
import jakarta.validation.constraints.NotEmpty;

public record CustomerDTO(
        Long id,
        String name,
        String masterEmail,
        String phone,
        String document,
        String category
) {

    public CustomerDTO(Customer customer) {
        this(customer.getId(),customer.getName(),customer.getMasterEmail(),customer.getPhone(),customer.getDocument(),customer.getCategory());
    }
}
