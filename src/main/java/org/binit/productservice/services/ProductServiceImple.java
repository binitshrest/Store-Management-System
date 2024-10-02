package org.binit.productservice.services;

import org.binit.productservice.dtos.FakeStoreRatingDto;
import org.binit.productservice.models.Category;
import org.binit.productservice.models.Product;
import org.binit.productservice.repositories.CategoryRepository;
import org.binit.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productserviceimple")
public class ProductServiceImple implements ProductService{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    //Injecting Product Repository in ProductServiceImpl
    public ProductServiceImple(ProductRepository productRepository,
                                CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProductById(Long id) {
        Optional<Product> data = productRepository.findById(id);
        return data.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product createProduct(String title, String description, double price, String imageUrl, String categoryTitle) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        Category categoryTitlefromDB = categoryRepository.findByTitle(categoryTitle);
        if(categoryTitlefromDB == null){
           Category newCategory = new Category();
           newCategory.setTitle(categoryTitle);
           categoryTitlefromDB = newCategory;
//           categoryTitlefromDB = categoryRepository.save(newCategory);
        }
        product.setCategory(categoryTitlefromDB);
        return productRepository.save(product);
    }

    @Override
    public Product updateAProduct(Product inputProduct) {
        Optional<Product> aProduct = productRepository.findById(inputProduct.getId());
        Product updatedProduct = aProduct.get();
        updatedProduct.setTitle(inputProduct.getTitle());
        updatedProduct.setPrice(inputProduct.getPrice());
        updatedProduct.setDescription(inputProduct.getDescription());
        updatedProduct.setImageUrl(inputProduct.getImageUrl());
        Optional<Category> aCategory = Optional.ofNullable(categoryRepository.findByTitle(inputProduct.getCategory().getTitle()));
        updatedProduct.setCategory(aCategory.get());
        return productRepository.save(updatedProduct);
    }

    @Override
    public List<Product> getByTitleAndPrice(String title, Double price) {
        List<Product> resultByTitleAndCategory = productRepository.findByTitleAndPrice(title, price);
        return resultByTitleAndCategory;
    }

    @Override
    public void deleteProductById(Long id) {

    }
}
