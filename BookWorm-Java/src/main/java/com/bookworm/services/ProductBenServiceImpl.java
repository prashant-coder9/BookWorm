package com.bookworm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.dao.ProductBenRepository;
import com.bookworm.entities.Product;
import com.bookworm.entities.ProductBenMaster;

@Service
public class ProductBenServiceImpl implements ProductBenService
{
	@Autowired
    ProductBenRepository probenRepo;

    @Override
    public List<ProductBenMaster> getByProduct(Long id) {
        return probenRepo.findByProductId(id);
    }
	
	
}
