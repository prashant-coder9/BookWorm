package com.bookworm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Customer {

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	private long customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String  city;
	private String country;
	private String phone_no;
	public Customer(int customer_id, String first_name, String last_name,String password, String email, String city,String country) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password=password;
		this.city = city;
		this.country=country;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getcustomer_id() {
		return customer_id;
	}
	public void setcustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getfirst_name() {
		return first_name;
	}
	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getlast_name() {
		return last_name;
	}
	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public String getcountry() {
		return country;
	}
	public void setcountry(String country) {
		this.country = country;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + "]";
	};
	
}

	
	
	
