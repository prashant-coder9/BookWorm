package com.bookworm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AttributeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int attribute_id;
    private String attribute_desc;
    
    
	public int getAttribute_id() {
		return attribute_id;
	}
	public void setAttribute_id(int attribute_id) {
		this.attribute_id = attribute_id;
	}
	public String getAttribute_desc() {
		return attribute_desc;
	}
	public void setAttribute_desc(String attribute_desc) {
		this.attribute_desc = attribute_desc;
	}
    

}