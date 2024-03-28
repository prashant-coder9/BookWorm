package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.entities.ProductAttribute;

public interface ProductAttributeService {


	 List<ProductAttribute> getAllProductAttributes();
	 Optional<ProductAttribute> getProductAttributeById(long id);
	 ProductAttribute createProductAttribute(ProductAttribute productAttribute) ;
	 void updateProductAttribute(long id, ProductAttribute updatedProductAttribute);
	 void deleteProductAttribute(long id);

}
