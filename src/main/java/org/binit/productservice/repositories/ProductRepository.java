package org.binit.productservice.repositories;

import org.binit.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product entity);
    List<Product> findAll();
}
