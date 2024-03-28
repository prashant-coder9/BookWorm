package com.bookworm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.dao.InvoiceDetailRepository;
import com.bookworm.entities.InvoiceDetail;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
	@Autowired
	InvoiceDetailRepository invoiceDetailRepo;
	@Override
	public void setInvoiceDetails(InvoiceDetail invdetails) {
		invoiceDetailRepo.save(invdetails);
		
	}																				
}
