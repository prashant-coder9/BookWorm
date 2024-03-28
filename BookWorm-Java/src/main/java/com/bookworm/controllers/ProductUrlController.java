package com.bookworm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.entities.ProductUrl;
import com.bookworm.services.ProductUrlService;

@RestController
public class ProductUrlController {

    private final ProductUrlService productDetailService;

    @Autowired
    public ProductUrlController(ProductUrlService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("/api/product/{productId}")
    public String getProductUrl(@PathVariable Integer productId) {
        return productDetailService.getUrlByProductId(productId);
    }
}
