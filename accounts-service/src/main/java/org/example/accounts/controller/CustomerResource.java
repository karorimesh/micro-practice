package org.example.accounts.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.example.accounts.dto.AccountCreateResponse;
import org.example.accounts.entities.Customer;
import org.example.accounts.repository.CustomerRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
    private final CustomerRepository customerRepository;

    public CustomerResource(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
//                .stream().peek(c -> c.setAccounts(null))
//                .collect(Collectors.toList());
        return new ResponseEntity<>(customers, HttpStatusCode.valueOf(HttpStatus.SC_OK));
    }
}
