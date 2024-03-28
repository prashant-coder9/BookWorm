package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.entities.ProductTypeMaster;

public interface IProductTypeMaster {

	
         List<ProductTypeMaster> getAllProducts();
         
         void addProductType(ProductTypeMaster pro);
         
         void delete (int id);
         
         void update(ProductTypeMaster p ,int id);
         
//         Optional <ProductTypeMaster> getByType(String type);
}
