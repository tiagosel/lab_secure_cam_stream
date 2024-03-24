package com.streamhub.videostreamhub.customer.controller.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCustomerDTO {
    private String name;
    @Email
    private String masterEmail;
    private String phone;
    private String document;
    private String category;
}
