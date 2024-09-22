package org.binit.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binit.productservice.models.Product;
import org.binit.productservice.models.Rating;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;
    private FakeStoreRatingDto rating;

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setPrice(getPrice());
        product.setDescription(getDescription());
        product.setImageUrl(getImage());
        product.setCategory(getCategory());


        return product;
    }
}
