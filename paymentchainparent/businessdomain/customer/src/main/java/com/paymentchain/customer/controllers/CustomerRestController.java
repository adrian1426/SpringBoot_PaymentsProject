package com.paymentchain.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentchain.customer.entities.Customer;
import com.paymentchain.customer.repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	
	@Autowired
	CustomerRepository customerRespository;
	
	@GetMapping()
	public List<Customer> findAll(){
		return customerRespository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<?> addCustomer(@RequestBody Customer customerInput){
		Customer newCustomer = customerRespository.save(customerInput);
		return ResponseEntity.ok(newCustomer);
	}
}
