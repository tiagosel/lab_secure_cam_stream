package com.streamhub.videostreamhub.customer.repository;


import com.streamhub.videostreamhub.customer.controller.dto.RegisterCustomerDTO;
import com.streamhub.videostreamhub.domain.Status;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;


    public void delete() {
        this.status = Status.DELETED;

    }


}
