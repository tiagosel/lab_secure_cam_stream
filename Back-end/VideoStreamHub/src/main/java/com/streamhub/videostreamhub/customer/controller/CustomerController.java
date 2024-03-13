package com.streamhub.videostreamhub.customer.controller;

import com.streamhub.videostreamhub.camera.controller.dto.CameraDTO;
import com.streamhub.videostreamhub.camera.controller.dto.RegisterCameraDTO;
import com.streamhub.videostreamhub.camera.repository.Camera;
import com.streamhub.videostreamhub.customer.controller.dto.CustomerDTO;
import com.streamhub.videostreamhub.customer.controller.dto.RegisterCustomerDTO;
import com.streamhub.videostreamhub.customer.repository.Customer;
import com.streamhub.videostreamhub.customer.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @PostMapping()
    @Transactional
    public ResponseEntity registerCamera(@RequestBody @Validated RegisterCustomerDTO registerCustomerDTO, UriComponentsBuilder uriBuilder) {
        var customer = new Customer(registerCustomerDTO);
        repository.save(customer);
        var uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
        ResponseEntity teste = ResponseEntity.created(uri).body(new CustomerDTO(customer));
        return teste;
    }
}
