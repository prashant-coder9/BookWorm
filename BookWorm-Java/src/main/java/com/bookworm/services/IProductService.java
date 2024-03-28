package com.bookworm.services;

import com.bookworm.entities.Product;
import java.util.List;
import java.util.Optional;

public interface IProductService {
	void addProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(long id);
	
	List<Product> getProductByType(long id);
	
	List<Product> getProductsByTypeandLang(long typeId, long lanId);
	
	Product getByid(long id);
   
	List<Product> GetProductsByTypeAndGenre(long typeId, long lanId,long genreId);
	
}
