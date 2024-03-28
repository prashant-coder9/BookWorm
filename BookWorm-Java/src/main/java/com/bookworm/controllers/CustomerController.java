package com.bookworm.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.entities.Customer;
import com.bookworm.entities.User;
import com.bookworm.services.CustomerManager;


@RestController  
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	CustomerManager manager;
	
	
	@PostMapping(value = "api/SignUp")
	 public void addpro(@RequestBody Customer cust)
	 {
		System.out.println("addCustomer called");
		manager.addCustomer(cust);
	 }
	 @GetMapping(value = "/api/get/{Id}")
	 public Optional<Customer> getCustomer(@PathVariable int Id) {
		 return manager.getCustomerById(Id);
	 }
	
	@PostMapping(value = "api/Login")
	public ResponseEntity<Customer> checkCustomer(@RequestBody User user1) {
		Customer customerResponse = manager.loginUser(user1.getEmail(), user1.getPassword());
		
		if(customerResponse!=null) {
			return ResponseEntity.ok(customerResponse);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	
}
