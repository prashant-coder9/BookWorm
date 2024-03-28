package com.bookworm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.entities.ProductTypeMaster;
import com.bookworm.dao.ProductTypeMasterRepository;

@Service
public class ProductTypeMasterImpl implements IProductTypeMaster {

    private final ProductTypeMasterRepository repository;

    @Autowired
    public ProductTypeMasterImpl(ProductTypeMasterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductTypeMaster> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public void addProductType(ProductTypeMaster pro) {
        repository.save(pro);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(ProductTypeMaster p, int id) {
        repository.update(p.getType_desc(), id);
    }

//    @Override
//    public Optional<ProductTypeMaster> getByType(String type) {
//        return repository.fin
//    }
}
