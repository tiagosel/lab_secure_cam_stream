package com.streamhub.videostreamhub.customer.controller;


import com.streamhub.videostreamhub.customer.controller.dto.CustomerDTO;
import com.streamhub.videostreamhub.customer.controller.dto.RegisterCustomerDTO;
import com.streamhub.videostreamhub.customer.repository.Customer;
import com.streamhub.videostreamhub.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    @Transactional
    public ResponseEntity registerCamera(@RequestBody @Validated RegisterCustomerDTO registerCustomerDTO, UriComponentsBuilder uriBuilder) {
        var customer = modelMapper.map(registerCustomerDTO, Customer.class);
        System.out.println(customer.getCategory());
        System.out.println(customer.getName());
        repository.save(customer);

        var uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(customer, CustomerDTO.class));
    }
}
