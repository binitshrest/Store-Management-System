package org.binit.productservice.services;

import org.binit.productservice.dtos.FakeStoreRatingDto;
import org.binit.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productserviceimple")
public class ProductServiceImple implements ProductService{
    @Override
    public Product getSingleProductById(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description, double price, String imageUrl, String category, FakeStoreRatingDto rating) {
        return null;
    }

    @Override
    public Product updateAProduct(Long id, String title, String image, String decription, String category, double price) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public void deleteProductById(Long id) {

    }
}
