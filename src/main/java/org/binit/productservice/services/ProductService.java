package org.binit.productservice.services;

import org.binit.productservice.dtos.CategoryDto;
import org.binit.productservice.dtos.FakeStoreRatingDto;
import org.binit.productservice.models.Category;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.Rating;

import java.util.List;

public interface ProductService {
    public Product getSingleProductById(Long id);
    public List<Product> getAllProducts();
    public Product createProduct( String title, String description,
                                  double price, String imageUrl,
                                  Category category);
    public Product updateAProduct(Product inputProduct);
    public List<Product> getByTitleAndPrice(String title, Double price);
    public List<Product> getProductByCategoryTitle(String categoryTitle);
    void deleteProductById(Long id);
    public List<Product> getProductByLowestPrice();
}
