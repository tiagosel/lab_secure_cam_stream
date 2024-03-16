package com.streamhub.videostreamhub.customer.controller.dto;


import com.streamhub.videostreamhub.customer.repository.Customer;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String name;
    private String masterEmail;
    private String phone;
    private String document;
    private String category;

}
