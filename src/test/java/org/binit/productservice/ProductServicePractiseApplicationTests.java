package org.binit.productservice;

import jakarta.transaction.Transactional;
import org.binit.productservice.models.Category;
import org.binit.productservice.models.Product;
import org.binit.productservice.repositories.CategoryRepository;
import org.binit.productservice.repositories.ProductRepository;
import org.binit.productservice.repositories.projections.getProductByIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServicePractiseApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads(){

    }

    @Test
    void testingQuery() {
        Product product = productRepository.getProductWithASpecificTitleAndId("Laptop", 52L);
        System.out.println(product.getTitle());
    }
    @Test
    void testingQuery2() {
        getProductByIdAndTitle product = productRepository.getProductWithATitleAndId("Laptop", 52L);
        System.out.println(product.getId());
        System.out.println(product.getTitle());
    }

    @Test
    @Transactional
    void testingFetchTypes(){
        Category category = categoryRepository.findByTitle("Laptop");
        System.out.println(category.getProducts());
    }

    @Test
    @Transactional
    void testingFetchTypes2(){
        Category category = categoryRepository.findByTitle("Laptop");
        System.out.println(category.getTitle());
    }

}
