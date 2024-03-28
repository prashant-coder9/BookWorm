package com.bookworm.services;

import java.util.List;

import com.bookworm.entities.Product;
import com.bookworm.entities.ProductBenMaster;

public interface ProductBenService 
{
	public List<ProductBenMaster> getByProduct(Long id);

}
