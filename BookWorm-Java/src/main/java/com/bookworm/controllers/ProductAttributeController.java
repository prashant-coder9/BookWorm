package com.bookworm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.entities.ProductAttribute;
import com.bookworm.services.ProductAttributeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/productAttribute")
public class ProductAttributeController {
	 @Autowired
    private  ProductAttributeService productAttributeService;


	    @GetMapping("/get")
	    public ResponseEntity<List<ProductAttribute>> getAllProductAttributes() {
	        List<ProductAttribute> productAttributes = productAttributeService.getAllProductAttributes();
	        return new ResponseEntity<>(productAttributes, HttpStatus.OK);
	    }

	    @GetMapping("/getbyid/{id}")
	    public ResponseEntity<ProductAttribute> getProductAttributeById(@PathVariable int id) {
	        Optional<ProductAttribute> productAttribute = productAttributeService.getProductAttributeById(id);
	        if (productAttribute.isPresent()) {
	            return new ResponseEntity<>(productAttribute.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @PostMapping("/add")
	    public ResponseEntity<ProductAttribute> createProductAttribute(@RequestBody ProductAttribute productAttribute) {
	    	System.out.println("Mukund "+productAttribute);
	        ProductAttribute createdAttribute = productAttributeService.createProductAttribute(productAttribute);
	        return new ResponseEntity<>(createdAttribute, HttpStatus.CREATED);
	    }

	    @PutMapping("/update/{id}")
	    public void updateProductAttribute(@PathVariable int id, @RequestBody ProductAttribute updatedProductAttribute) {
	    	productAttributeService.updateProductAttribute(id, updatedProductAttribute);
	       
	    }

	    @DeleteMapping("delete/{id}")
	    public ResponseEntity<Void> deleteProductAttribute(@PathVariable long id) {
	        productAttributeService.deleteProductAttribute(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
