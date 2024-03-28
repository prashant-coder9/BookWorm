package com.bookworm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ProductAttribute {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodAttId;
    
	@OneToOne
    @JoinColumn(name = "attribute_id")
    private AttributeMaster Attribute_id;
	@OneToOne
	@JoinColumn(name = "product_Id")
    private Product Product_id;
    
    private String attributeValue;

	public Long getProdAttId() {
		return prodAttId;
	}

	public void setProdAttId(Long prodAttId) {
		this.prodAttId = prodAttId;
	}

	public AttributeMaster getAttribute() {
		return Attribute_id;
	}

	public void setAttribute(AttributeMaster Attribute_id) {
		this.Attribute_id = Attribute_id;
	}

	public Product getProduct() {
		return Product_id;
	}

	public void setProduct(Product Product_id) {
		this.Product_id = Product_id;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
    

}
