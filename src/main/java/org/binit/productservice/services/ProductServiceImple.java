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
    public Product createProduct(String title, String description, double price, String imageUrl, Category category) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        String categoryTitle = category.getTitle(); // Extract the title from the Category object
        Category categoryFromDB = categoryRepository.findByTitle(categoryTitle);

        if (categoryFromDB == null) {
            // Save the new category if it does not exist
            categoryFromDB = categoryRepository.save(category);
        }

        product.setCategory(categoryFromDB);
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

    //Get Product by categoryTitle
    @Override
    public List<Product> getProductByCategoryTitle(String categoryTitle) {
        List<Product> findByCategoryTitle = productRepository.findByCategory_title(categoryTitle);
        return findByCategoryTitle;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductByLowestPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    //get by price lowest
    //get by price highest

}
