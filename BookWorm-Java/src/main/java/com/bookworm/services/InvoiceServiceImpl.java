package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.entities.Invoice;
import com.bookworm.dao.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> getAllInvoice() {
		return invoiceRepository.findAll();
	}
	@Override
	public Optional<Invoice> getById(long id) {
		return invoiceRepository.findById(id);
	}
	
	@Override
	public void addtoInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
		
	}
	
	@Override
	public void deleteByInvoiceId(long id) {
		invoiceRepository.deleteById(id);
	}
	@Override
	public List<Invoice> getByCustomerId(long id) {
		 return invoiceRepository.getByCustomerId(id);
		
	}
}
