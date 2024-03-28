package com.bookworm.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class RoyaltyCalculation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long royalty_calculation_id;
	private long invoice_id;
	private long beneficiary_id;
	private LocalDate royalty_calculation_date;
	private long product_id;
	private int quantity;
	private String transaction_type;
	private double base_price;
	private double sale_price;
	private double royalty_on_base_price;
	
	
	public long getRoyalty_calculation_id() {
		return royalty_calculation_id;
	}
	public void setRoyalty_calculation_id(long royalty_calculation_id) {
		this.royalty_calculation_id = royalty_calculation_id;
	}
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	public long getBeneficiary_id() {
		return beneficiary_id;
	}
	public void setBeneficiary_id(long beneficiary_id) {
		this.beneficiary_id = beneficiary_id;
	}
	public LocalDate getRoyalty_calculation_date() {
		return royalty_calculation_date;
	}
	public void setRoyalty_calculation_date(LocalDate localDate) {
		this.royalty_calculation_date = localDate;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String string) {
		this.transaction_type = string;
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
	public double getRoyalty_on_base_price() {
		return royalty_on_base_price;
	}
	public void setRoyalty_on_base_price(double royalty_on_base_price) {
		this.royalty_on_base_price = royalty_on_base_price;
	}
	

}
