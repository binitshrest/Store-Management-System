package org.binit.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binit.productservice.models.Category;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.Rating;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDto {
    private String title;
    private String imageUrl;
    private String description;
    private CategoryDto category;
    private double price;

    public Product mapToEntity(Long id, CreateProductRequestDto dto) {
        Product product = new Product();
        product.setId(id);
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImageUrl(dto.getImageUrl());
        if(dto.getCategory() != null) {
            Category category = new Category();
            category.setTitle(dto.getCategory().getTitle());
            product.setCategory(category);
        } else {
            product.setCategory(null); // Or handle as per your business logic
        }
        return product;
    }
}
