package com.bookworm.entities;

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
public class ProductBenMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prodBenId;
    @ManyToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinColumn(name = "benId")
    private BeneficiaryMaster  ProdBen_ben_id ;
    @ManyToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinColumn(name = "prodBenProductId")
    private Product  ProdBen_product_id;
    private double  ProdBen_percentage ;
	public long getProdBenId() {
		return prodBenId;
	}
	public void setProdBenId(long prodBenId) {
		this.prodBenId = prodBenId;
	}
	public BeneficiaryMaster getProdBen_ben_id() {
		return ProdBen_ben_id;
	}
	public void setProdBen_ben_id(BeneficiaryMaster prodBen_ben_id) {
		ProdBen_ben_id = prodBen_ben_id;
	}
	public Product getProdBen_product_id() {
		return ProdBen_product_id;
	}
	public void setProdBen_product_id(Product prodBen_product_id) {
		ProdBen_product_id = prodBen_product_id;
	}
	public double getProdBen_percentage() {
		return ProdBen_percentage;
	}
	public void setProdBen_percentage(double prodBen_percentage) {
		ProdBen_percentage = prodBen_percentage;
	}
	@Override
	public String toString() {
		return "ProductBenMaster [prodBenId=" + prodBenId + ", ProdBen_ben_id=" + ProdBen_ben_id
				+ ", ProdBen_product_id=" + ProdBen_product_id + ", ProdBen_percentage=" + ProdBen_percentage + "]";
	}
}
    
    
    
