package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.dao.ProductAttributeRepository;
import com.bookworm.entities.ProductAttribute;
@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
	   @Autowired
	 private  ProductAttributeRepository productAttributeRepository;


	    @Override
	    public List<ProductAttribute> getAllProductAttributes() {
	        return productAttributeRepository.findAll();
	    }

	    @Override
	    public Optional<ProductAttribute> getProductAttributeById(long id) {
	        return productAttributeRepository.findById(id);
	    }

	    @Override
	    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
	    	
	        
	        return productAttributeRepository.save(productAttribute);
	    }

	    @Override
	    public void updateProductAttribute(long id, ProductAttribute updatedProductAttribute) {
	               productAttributeRepository.update(updatedProductAttribute.getAttributeValue(),id);
	    }

	    @Override
	    public void deleteProductAttribute(long id) {
	        productAttributeRepository.deleteById(id);
	    }
}
