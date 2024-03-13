package com.streamhub.videostreamhub.customer.repository;


import com.streamhub.videostreamhub.customer.controller.dto.RegisterCustomerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "customer")
@Entity(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String masterEmail;

    private String phone;

    private String document;

    private String category;

    public Customer(RegisterCustomerDTO registerCustomerDTO) {
        this.name = registerCustomerDTO.name();
        this.masterEmail = registerCustomerDTO.masterEmail();
        this.phone = registerCustomerDTO.phone();
        this.document = registerCustomerDTO.document();
        this.category = registerCustomerDTO.category();
    }
}
