package com.bookworm.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookworm.entities.ProductTypeMaster;
import com.bookworm.services.IProductTypeMaster;

@RestController
@RequestMapping("/api/productType")
@CrossOrigin("*")
public class ProductTypeMasterController {

    @Autowired
    IProductTypeMaster p;

    @GetMapping(value = "/getAll")
    public List<ProductTypeMaster> showAllProducts() {
        return p.getAllProducts();
    }

    @DeleteMapping(value = "/delete/{pid}")
    public void deleteProduct(@PathVariable int pid) {
        p.delete(pid);
    }

    @PutMapping(value = "/update/{pid}")
    public void updateProduct(@RequestBody ProductTypeMaster product, @PathVariable int pid) {
        p.update(product, pid);
    }

    @PostMapping(value = "/add")
    public void addProduct(@RequestBody ProductTypeMaster product) {
        p.addProductType(product);
    }

//    @GetMapping("/getbytype/{type}")
//    public Optional<ProductTypeMaster> getByType(@PathVariable String type) {
//        return p.getByType(type);
//    }
}
