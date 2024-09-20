package org.binit.productservice.services;

import org.binit.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProductById(Long id);
    public List<Product> getAllProducts();
}
