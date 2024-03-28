package com.bookworm.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bookworm.entities.Invoice;
import com.bookworm.services.InvoiceService;

@RestController
@CrossOrigin("*")
public class InvoiceController {
	
	@Autowired
	private InvoiceService inService;
	
	@GetMapping(value="/api/getAllInvoice")
	public List<Invoice> getAllInvoice()
	{
		return inService.getAllInvoice();
	}
	
	@GetMapping(value="/api/getById/{id}")
	public Optional<Invoice> getById(@PathVariable long id) 
	{
		return inService.getById(id);
	}

	@PostMapping(value="/api/addInvoice")
	public void addInvoice(@RequestBody Invoice invoice) {
		inService.addtoInvoice(invoice);
	}
	
	@DeleteMapping("/api/delete/{id}")
	public void deleteByInvoiceId(@PathVariable long id) {
		inService.deleteByInvoiceId(id);
	}
	@GetMapping("/ByCustomerId/{id}")
	public List<Invoice> getByCustomerId(@PathVariable long id) {
		return inService.getByCustomerId(id);
	}
}
