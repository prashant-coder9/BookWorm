package com.bookworm.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity 
public class MyShelf {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shelfId;
	private int customerId;
	private int buyId;
	private int rentId;
    private String tranType;
    private LocalDate  productExpiryDate;
    private boolean isActive;
    private String productName;
    private double priceAmount;
    private double totalAmount;
    
    
	public double getPriceAmount() {
		return priceAmount;
	}
	public void setPriceAmount(double priceAmount) {
		this.priceAmount = priceAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getShelfId() {
		return shelfId;
	}
	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public LocalDate getProductExpiryDate() {
		return productExpiryDate;
	}
	public void setProductExpiryDate(LocalDate productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "MyShelf [shelfId=" + shelfId + ", customerId=" + customerId + ", buyId=" + buyId + ", rentId=" + rentId
				+ ", tranType=" + tranType + ", productExpiryDate=" + productExpiryDate + ", isActive=" + isActive
				+ "]";
	}

}
