package com.bookworm.dtos;

import java.time.LocalDateTime;

import com.bookworm.entities.Customer;
import com.bookworm.entities.Invoice;
import com.bookworm.entities.Product;

public class InvoiceDto {
	private LocalDateTime invoice_date;
	private long customer_id;
	private double invoice_amount;
	private long invoice_id;
	private long product_id;
	private double base_price;
	private double sale_price;
	private char transaction_type;
	private int rent_days;
	
	public LocalDateTime getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(LocalDateTime invoice_date) {
		this.invoice_date = invoice_date;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public double getInvoice_amount() {
		return invoice_amount;
	}
	public void setInvoice_amount(double invoice_amount) {
		this.invoice_amount = invoice_amount;
	}
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public double getBase_price() {
		return base_price;
	}
	public void setBase_price(double base_price) {
		this.base_price = base_price;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public char getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(char transaction_type) {
		this.transaction_type = transaction_type;
	}
	public int getRent_days() {
		return rent_days;
	}
	public void setRent_days(int rent_days) {
		this.rent_days = rent_days;
	}
}
