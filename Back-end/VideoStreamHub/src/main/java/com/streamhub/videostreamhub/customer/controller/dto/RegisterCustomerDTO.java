package com.streamhub.videostreamhub.customer.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCustomerDTO

 {
       @NotEmpty
       private String name;
       @Email
       private String masterEmail;


       @NotEmpty
       private String phone;


       @NotEmpty
       private String document;


       @NotEmpty
       private String category;
}
