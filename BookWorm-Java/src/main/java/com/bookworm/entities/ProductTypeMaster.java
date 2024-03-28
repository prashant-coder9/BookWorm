package com.bookworm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int type_id ;
    private String type_desc;
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_desc() {
		return type_desc;
	}
	public void setType_desc(String type_desc) {
		this.type_desc = type_desc;
	}
	@Override
	public String toString() {
		return "ProductTypeMaster [type_id=" + type_id + ", type_desc=" + type_desc + "]";
	}
}