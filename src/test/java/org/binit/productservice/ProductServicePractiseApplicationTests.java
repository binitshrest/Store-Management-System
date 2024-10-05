package org.binit.productservice;

import org.binit.productservice.models.Product;
import org.binit.productservice.repositories.ProductRepository;
import org.binit.productservice.repositories.projections.getProductByIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServicePractiseApplicationTests {

    @Autowired
    ProductRepository productRepository;

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

}
