package com.bookworm.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookworm.entities.Customer;
import com.bookworm.dao.ICustomerRepository;


@Service
public class CustomerManagerImpl implements CustomerManager
{
	@Autowired
	ICustomerRepository repository;

	@Override
	public void addCustomer(Customer c) {
		repository.save(c);
	}
	
	@Override
	public Customer loginUser(String email, String password) {
		
		Customer cust= repository.loginUser(email,password);
		if(cust.getemail().equals(email)&& cust.getpassword().equals(password)) {
		return cust;
		}else {
			return null;
		}
		
	}
		
	@Override
	public Optional<Customer> getCustomerById(int Id) {
		return repository.findById(Id);
	}
		

}
