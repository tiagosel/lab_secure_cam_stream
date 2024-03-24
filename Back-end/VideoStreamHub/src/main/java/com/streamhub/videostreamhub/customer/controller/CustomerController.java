package com.streamhub.videostreamhub.customer.controller;



import com.streamhub.videostreamhub.customer.controller.dto.CustomerDTO;
import com.streamhub.videostreamhub.customer.controller.dto.RegisterCustomerDTO;
import com.streamhub.videostreamhub.customer.controller.dto.UpdateCustomerDTO;
import com.streamhub.videostreamhub.customer.repository.Customer;
import com.streamhub.videostreamhub.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
        repository.save(customer);
        var uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(customer, CustomerDTO.class));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity updateCamera(@RequestBody @Validated UpdateCustomerDTO updateCustomerDTO, UriComponentsBuilder uriBuilder, @PathVariable Long id) {
        var customer = repository.getReferenceById(id);
        modelMapper.map(updateCustomerDTO,customer);
        var uri = uriBuilder.path("/camera/{id}").buildAndExpand(customer.getId()).toUri();
        var  cameraDTO = modelMapper.map(customer, CustomerDTO.class);
        return ResponseEntity.created(uri).body(cameraDTO);
    }


    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var customer = repository.getReferenceById(id);
        customer.delete();
        return ResponseEntity.noContent().build();
    }




}
