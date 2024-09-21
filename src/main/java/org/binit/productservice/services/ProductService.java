package org.binit.productservice.services;

import org.binit.productservice.dtos.FakeStoreRatingDto;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.Rating;

import java.util.List;

public interface ProductService {
    public Product getSingleProductById(Long id);
    public List<Product> getAllProducts();
    public Product createProduct( String title, String description,
                                  double price, String imageUrl,
                                  String category
//                                  FakeStoreRatingDto rating
    );
    public Product updateAProduct(Long id, String title, String image, String decription, String category, double price);
}
