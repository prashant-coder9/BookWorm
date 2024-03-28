package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.dao.IProductRepository;
import com.bookworm.entities.Product;

import jakarta.transaction.Transactional;

@Transactional
@Service 
public class ProductService implements IProductService {
	
	@Autowired
	private IProductRepository productRepo;

	@Override
	public void addProduct(Product product) {
		productRepo.save(product);
		System.out.println("Product Added: " + product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public List<Product> getProductByType(long id) {
		List<Product> prod = productRepo.getByTypeID(id);
		return prod;
	}
	
	@Override
	public List<Product> getProductsByTypeandLang(long typeid, long langId) {
		return productRepo.getByTypeIdandLangID(typeid, langId);
	}

	
	@Override
	public Product getProductById(long id) {
		return productRepo.getById(id);
	}
	@Override
	public Product getByid(long id) {
		
		return productRepo.findByProductId(id);
	}

	@Override
	public List<Product> GetProductsByTypeAndGenre(long typeId, long lanId, long genreId) {
		return productRepo.getByTypeandGenre(typeId, lanId, genreId);
		
	}
}
