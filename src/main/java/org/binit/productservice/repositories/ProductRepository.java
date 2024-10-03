package org.binit.productservice.repositories;

import org.binit.productservice.models.Category;
import org.binit.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
//    List<Product> findAllByOrderByPriceDesc(); // For descending order

//  HQL is flexible and build on top of sql and other database.
//  If database is changed doesn't impact on written query
    @Query("select p from Product p where p.category.title = :title and p.id= :id")
    Product getProductWithASpecificTitleAndId(@Param("title")String title
                                            , @Param("id") Long id);

    @Query(value = "Select * from Product where title=:title and id = :id", nativeQuery = true)
    Product getProductWithASomeTitleAndId(@Param("title") String title, @Param("id") Long id);
}
