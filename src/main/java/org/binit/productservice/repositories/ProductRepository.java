package org.binit.productservice.repositories;

import org.binit.productservice.models.Category;
import org.binit.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product entity);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findByTitleAndPrice(String title, Double price);
    List<Product> findByCategory_title(String categoryTitle);
    void deleteById(Long id);
    List<Product> findAllByOrderByPriceAsc(); // For ascending order
    List<Product> findAllByOrderByPriceDesc(); // For descending order
}
