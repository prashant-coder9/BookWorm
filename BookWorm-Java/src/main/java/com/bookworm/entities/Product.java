package com.bookworm.entities;

import java.time.LocalDate;

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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;
    private String product_name;
    private String product_english_name; 
    @ManyToOne
	@JoinColumn(name = "type_id")
    private ProductTypeMaster product_type;
    private double product_baseprice;
    private double product_sp_cost;
    private double product_offerprice;
    private LocalDate product_off_price_expirydate;
    private String product_description_short;
    private String product_description_long;
    private String product_isbn;
    private String product_author;
    private String product_publisher;
    @ManyToOne
	@JoinColumn(name = "languageId")
    private LanguageMaster product_lang;
    @ManyToOne
	@JoinColumn(name = "genreId")
    private GenreMaster product_genre;
    private boolean is_Rentable;
    private double rent_per_day;
    private int min_rent_days;
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_english_name() {
		return product_english_name;
	}
	public void setProduct_english_name(String product_english_name) {
		this.product_english_name = product_english_name;
	}
	public ProductTypeMaster getProduct_type() {
		return product_type;
	}
	public void setProduct_type(ProductTypeMaster product_type) {
		this.product_type = product_type;
	}
	public double getProduct_baseprice() {
		return product_baseprice;
	}
	public void setProduct_baseprice(double product_baseprice) {
		this.product_baseprice = product_baseprice;
	}
	public double getProduct_sp_cost() {
		return product_sp_cost;
	}
	public void setProduct_sp_cost(double product_sp_cost) {
		this.product_sp_cost = product_sp_cost;
	}
	public double getProduct_offerprice() {
		return product_offerprice;
	}
	public void setProduct_offerprice(double product_offerprice) {
		this.product_offerprice = product_offerprice;
	}
	public LocalDate getProduct_off_price_expirydate() {
		return product_off_price_expirydate;
	}
	public void setProduct_off_price_expirydate(LocalDate product_off_price_expirydate) {
		this.product_off_price_expirydate = product_off_price_expirydate;
	}
	public String getProduct_description_short() {
		return product_description_short;
	}
	public void setProduct_description_short(String product_description_short) {
		this.product_description_short = product_description_short;
	}
	public String getProduct_description_long() {
		return product_description_long;
	}
	public void setProduct_description_long(String product_description_long) {
		this.product_description_long = product_description_long;
	}
	public String getProduct_isbn() {
		return product_isbn;
	}
	public void setProduct_isbn(String product_isbn) {
		this.product_isbn = product_isbn;
	}
	public String getProduct_author() {
		return product_author;
	}
	public void setProduct_author(String product_author) {
		this.product_author = product_author;
	}
	public String getProduct_publisher() {
		return product_publisher;
	}
	public void setProduct_publisher(String product_publisher) {
		this.product_publisher = product_publisher;
	}
	public LanguageMaster getProduct_lang() {
		return product_lang;
	}
	public void setProduct_lang(LanguageMaster product_lang) {
		this.product_lang = product_lang;
	}
	public GenreMaster getProduct_genre() {
		return product_genre;
	}
	public void setProduct_genre(GenreMaster product_genre) {
		this.product_genre = product_genre;
	}
	public boolean isIs_Rentable() {
		return is_Rentable;
	}
	public void setIs_Rentable(boolean is_Rentable) {
		this.is_Rentable = is_Rentable;
	}
	public double getRent_per_day() {
		return rent_per_day;
	}
	public void setRent_per_day(double rent_per_day) {
		this.rent_per_day = rent_per_day;
	}
	public int getMin_rent_days() {
		return min_rent_days;
	}
	public void setMin_rent_days(int min_rent_days) {
		this.min_rent_days = min_rent_days;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_english_name="
				+ product_english_name + ", product_type=" + product_type + ", product_baseprice=" + product_baseprice
				+ ", product_sp_cost=" + product_sp_cost + ", product_offerprice=" + product_offerprice
				+ ", product_off_price_expirydate=" + product_off_price_expirydate + ", product_description_short="
				+ product_description_short + ", product_description_long=" + product_description_long
				+ ", product_isbn=" + product_isbn + ", product_author=" + product_author + ", product_publisher="
				+ product_publisher + ", product_lang=" + product_lang + ", product_genre=" + product_genre
				+ ", is_Rentable=" + is_Rentable + ", rent_per_day=" + rent_per_day + ", min_rent_days=" + min_rent_days
				+ "]";
	}
	
	
}
   
    
    
