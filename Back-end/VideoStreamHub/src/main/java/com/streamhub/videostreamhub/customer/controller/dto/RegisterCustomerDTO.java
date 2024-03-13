package com.streamhub.videostreamhub.customer.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record RegisterCustomerDTO(
        @NotEmpty
        String name,
        @Email
        String masterEmail,
        @NotEmpty
        String phone,
        @NotEmpty
        String document,
        @NotEmpty
        String category
) {
}
