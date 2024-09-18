package org.binit.productservice.services;

import org.binit.productservice.models.Product;

public interface ProductService {
    public Product getSingleProductById(Long id);
}
